package com.catchmind.admin.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("")
    public ModelAndView userMain() {
        return new ModelAndView("user/user");
    }

    @GetMapping("/detail")
    public ModelAndView userDetail() {
        return new ModelAndView("user/user_detail");
    }
}
