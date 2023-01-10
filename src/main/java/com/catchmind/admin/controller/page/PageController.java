package com.catchmind.admin.controller.page;

import com.catchmind.admin.service.AdminUserApiLogicService;
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
    private AdminUserApiLogicService adminUserApiLogicService;

    @Autowired
    private TalkAdminApiLogicService talkAdminApiLogicService;

    @GetMapping("")
    public ModelAndView index(HttpServletRequest request) {
        HttpSession session =request.getSession(false);
        String id = null;
        String name = null;

        if(session == null){
            System.out.println("세션이 없습니다.");
            return new ModelAndView("/login");

        }else{
            id = (String)session.getAttribute("id");
            name = (String)session.getAttribute("name");
            System.out.println("세션이 있습니다.");
        }
        return new ModelAndView("/index")
                .addObject("id", id)
                .addObject("name",name);
    }

    @RequestMapping("login")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @PostMapping(path="/loginOk")  // http://localhost:8888/loginOk
    public String loginOk(HttpServletRequest request, String meUserid, String meUserpw){
        if(adminUserApiLogicService.read(meUserid,meUserpw).getData()!= null) {
            HttpSession session = request.getSession();
            String meName = adminUserApiLogicService.read(meUserid, meUserpw).getData().getMeName();
            session.setAttribute("id",meUserid);
            session.setAttribute("name",meName);
            return "redirect:/";
        }else{
            return "redirect:/login";
        }
    }

    @RequestMapping("join")
    public ModelAndView join() {
        return new ModelAndView("/join");
    }

    @GetMapping("calender")
    public ModelAndView calender() {
        return new ModelAndView("/calender");
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

}
