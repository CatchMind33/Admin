package com.catchmind.admin.controller.page;

import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.response.TalkAdminApiResponse;
import com.catchmind.admin.service.AdminLogicService;
import com.catchmind.admin.service.PaginationService;
import com.catchmind.admin.service.TalkAdminApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class PageController {
    private final AdminLogicService adminLogicService;
    private final PaginationService paginationService;
    private final TalkAdminApiLogicService talkAdminApiLogicService;

    @GetMapping("")
    public ModelAndView index(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {
            return new ModelAndView("/login");
        } else {
            userid= (String)session.getAttribute("userid");
            name= (String)session.getAttribute("name");
        }

        return new ModelAndView("/index")
                .addObject("userid", userid)
                .addObject("name", name);
    }

    @GetMapping("login")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @GetMapping("join")
    public ModelAndView join() {
        return new ModelAndView("/join");
    }

    @GetMapping("message")
    public ModelAndView message(@PageableDefault(size=10, sort="taaIdx", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<TalkAdminApiResponse> talks = talkAdminApiLogicService.msgList(pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumber(pageable.getPageNumber(), talks.getTotalPages());
        ModelAndView view = new ModelAndView("/message");
        view.addObject("talks", talks);
        view.addObject("paginationBarNumbers",barNumbers);
        return view;
    }

    @GetMapping("message/detail/{taaIdx}")
    public ModelAndView messageDetail(@PathVariable Long taaIdx) {
        Header<TalkAdminApiResponse> talk = talkAdminApiLogicService.read(taaIdx);
        ModelAndView view = new ModelAndView("/message_detail");
        view.addObject("talk", talk.getData());
        return view;
    }

    // 로그인 구현
    @PostMapping(path="/loginOk")  // http://localhost:8888/loginOk
    public String loginOk(HttpServletRequest request, String adUserid, String adUserpw){
        if(adminLogicService.read(adUserid,adUserpw).getData()!= null) {
            HttpSession session = request.getSession();
            String name = adminLogicService.read(adUserid, adUserpw).getData().getAdName();
            String userid = adminLogicService.read(adUserid, adUserpw).getData().getAdUserid();
            session.setAttribute("userid",userid);
            session.setAttribute("name",name);
            return "redirect:/";
        }else{
            return "redirect:/login";
        }
    }

}
