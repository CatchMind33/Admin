package com.catchmind.admin.controller.page;

import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.response.NoticeApiResponse;
import com.catchmind.admin.service.NoticeApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("service")
public class ServiceController {

    @Autowired
    private NoticeApiLogicService noticeApiLogicService;


    @GetMapping("/notice")
    public ModelAndView notice() {
        ModelAndView view = new ModelAndView("/service/notice"); //
        view.addObject("notices",noticeApiLogicService.noticeList());
//        System.out.println(noticeApiLogicService.noticeList());
        return view;
    }


    @GetMapping("/notice/detail/{noIdx}")
    public ModelAndView noticeDetail(@PathVariable Long noIdx) {
        ModelAndView view = new ModelAndView("/service/notice_detail");
        Header<NoticeApiResponse> api = noticeApiLogicService.read(noIdx);
        view.addObject("detail", api.getData());
        return view;

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

    @GetMapping("/imp")
    public ModelAndView service1() {
        return new ModelAndView("/service/service_imp");
    }

    @GetMapping("imp/detail")
    public ModelAndView serviceDetail1() {
        return new ModelAndView("/service/service_imp_detail");
    }
}
