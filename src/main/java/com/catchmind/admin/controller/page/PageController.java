package com.catchmind.admin.controller.page;

import com.catchmind.admin.service.AdminLogicService;
import com.catchmind.admin.service.TalkAdminApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("")
public class PageController {
    @Autowired
    private AdminLogicService adminLogicService;

    @Autowired
    private TalkAdminApiLogicService talkAdminApiLogicService;


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
    public ModelAndView message() {
        ModelAndView view = new ModelAndView("/message");
        view.addObject("msglist",talkAdminApiLogicService.msgList());
        return view;
    }

    @GetMapping("message/detail")
    public ModelAndView messageDetail() {
        return new ModelAndView("/message_detail");
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
