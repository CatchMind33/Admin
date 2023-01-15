package com.catchmind.admin.controller.page;

import com.catchmind.admin.model.entity.Ask;
import com.catchmind.admin.model.entity.Improvement;
import com.catchmind.admin.model.entity.Notice;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.response.AskApiResponse;
import com.catchmind.admin.model.network.response.ImpApiResponse;
import com.catchmind.admin.model.network.response.NoticeApiResponse;
import com.catchmind.admin.service.AskApiLogicService;
import com.catchmind.admin.service.ImpApiLogicService;
import com.catchmind.admin.service.NoticeApiLogicService;
import com.catchmind.admin.service.PaginationService;
import lombok.RequiredArgsConstructor;
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
    private final AskApiLogicService askApiLogicService;
    private final ImpApiLogicService impApiLogicService;

    // 전체 공지사항 리스트
    @GetMapping("/notice")
    public String notice(@PageableDefault(size = 10, sort = "noIdx", direction = Sort.Direction.DESC) Pageable pageable, ModelMap map) {
        Page<Notice> notices = noticeApiLogicService.noticeList(pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumber(pageable.getPageNumber(), notices.getTotalPages());
        map.addAttribute("notices", notices);
        map.addAttribute("paginationBarNumbers", barNumbers);
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

    // 공지사항 작성
    @GetMapping("notice/write")
    public ModelAndView noticeWrite() {
        return new ModelAndView("/service/notice_write");
    }


    // 문의사항 리스트
    @GetMapping("/ask")
    public String service(@PageableDefault(size = 10, sort = "askIdx", direction = Sort.Direction.DESC) Pageable pageable, ModelMap map) {
        Page<Ask> asks = askApiLogicService.askList(pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumber(pageable.getPageNumber(), asks.getTotalPages());
        map.addAttribute("asks", asks);
        map.addAttribute("paginationBarNumbers", barNumbers);
        return "/service/service_center";
    }

    // 문의 사항 상세
    @GetMapping("/ask/detail/{askIdx}")
    public ModelAndView askDetail(@PathVariable Long askIdx) {
        ModelAndView view = new ModelAndView("/service/service_center_detail");
        Header<AskApiResponse> api = askApiLogicService.read(askIdx);
        view.addObject("ask", api.getData());
        return view;
    }

    // 개선사항 리스트
    @GetMapping("/imp")
    public String improvement(@PageableDefault(size = 10, sort = "impIdx", direction = Sort.Direction.DESC) Pageable pageable, ModelMap map) {
        Page<Improvement> improvements = impApiLogicService.impList(pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumber(pageable.getPageNumber(), improvements.getTotalPages());
        map.addAttribute("improvements", improvements);
        map.addAttribute("paginationBarNumbers", barNumbers);
        return "/service/service_imp";
    }

    // 개선사항 상세
    @GetMapping("/imp/detail/{impIdx}")
    public ModelAndView improvementDetail(@PathVariable Long impIdx) {
        ModelAndView view = new ModelAndView("/service/service_imp_detail");
        Header<ImpApiResponse> api = impApiLogicService.read(impIdx);
        view.addObject("imp", api.getData());
        return view;
    }
}
