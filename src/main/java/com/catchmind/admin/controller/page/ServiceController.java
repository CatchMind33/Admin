package com.catchmind.admin.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("service")
public class ServiceController {

    @GetMapping("/notice")
    public ModelAndView notice() {
        return new ModelAndView("/service/notice");
    }

    @GetMapping("/notice/detail")
    public ModelAndView noticeDetail() {
        return new ModelAndView("/service/notice_detail");
    }

    @GetMapping("notice/write")
    public ModelAndView noticeWrite() {
        return new ModelAndView("/service/notice_write");
    }

    @GetMapping("/ask")
    public ModelAndView service() {
        return new ModelAndView("/service/service_center");
    }

    @GetMapping("ask/detail")
    public ModelAndView serviceDetail() {
        return new ModelAndView("/service/service_center_detail");
    }
}
