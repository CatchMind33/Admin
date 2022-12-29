package com.catchmind.admin.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("owner")
public class OwnerController {

    @GetMapping("")
    public ModelAndView ownerMain() {
        return new ModelAndView("owner/owner");
    }

    @GetMapping("/detail")
    public ModelAndView ownerDetail() {
        return new ModelAndView("owner/owner_detail");
    }

    @GetMapping("/new")
    public ModelAndView newOwner() {
        return new ModelAndView("owner/new_owner");
    }

    @GetMapping("/new/detail")
    public ModelAndView newOwnerDetail() {
        return new ModelAndView("owner/new_owner_detail");
    }

}

