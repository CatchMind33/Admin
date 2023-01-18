package com.catchmind.admin.controller.page;

import com.catchmind.admin.service.ReviewLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("review")
public class ReviewController {

    @Autowired
    private ReviewLogicService reviewLogicService;

//    @GetMapping("")
//    public ModelAndView reviewMain() {
//        return new ModelAndView("review/review");
//    }

    @GetMapping("")
    public ModelAndView reviewMain() {
        ModelAndView view = new ModelAndView("/review/review");
        view.addObject("reviews", reviewLogicService.reviewList());
        return view;
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
