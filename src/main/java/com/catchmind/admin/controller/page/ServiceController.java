package com.catchmind.admin.controller.page;

import com.catchmind.admin.model.entity.Notice;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.response.NoticeApiResponse;
import com.catchmind.admin.service.NoticeApiLogicService;
import com.catchmind.admin.service.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("service")
@RequiredArgsConstructor
public class ServiceController {

    private final NoticeApiLogicService noticeApiLogicService;
    private final PaginationService paginationService;

    // 전체 공지사항 리스트
    @GetMapping("/notice")
    public String notice(@PageableDefault(size=10, sort="noIdx", direction = Sort.Direction.DESC) Pageable pageable, ModelMap map) {
        Page<Notice> notices = noticeApiLogicService.noticeList(pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumber(pageable.getPageNumber(), notices.getTotalPages());
        map.addAttribute("notices", notices);
        map.addAttribute("paginationBarNumbers",barNumbers);
        return "service/notice";

    }

    // 공지사항 상세
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
    public ModelAndView serviceImp() {
        return new ModelAndView("/service/service_imp");
    }

    @GetMapping("/imp/detail")
    public ModelAndView serviceImpDetail() {
        return new ModelAndView("/service/service_imp_detail");
    }
}
