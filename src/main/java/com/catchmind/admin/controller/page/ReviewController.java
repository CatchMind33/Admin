package com.catchmind.admin.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("review")
public class ReviewController {

    @GetMapping("")
    public ModelAndView reviewMain() {
        return new ModelAndView("review/review");
    }
    @GetMapping("/detail")
    public ModelAndView reviewDetail() {
        return new ModelAndView("review/review_detail");
    }
    @GetMapping("/report")
    public ModelAndView reviewReport() {
        return new ModelAndView("review/review_report");
    }
}
