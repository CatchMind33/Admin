package com.catchmind.admin.controller.page;

import com.catchmind.admin.controller.api.RestAdminApiController;
import com.catchmind.admin.model.entity.Pending;
import com.catchmind.admin.model.entity.ResAdmin;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.response.NoticeApiResponse;
import com.catchmind.admin.model.network.response.PendingApiResponse;
import com.catchmind.admin.repository.PendingRepository;
import com.catchmind.admin.service.PaginationService;
import com.catchmind.admin.service.PendingApiLogicService;
import com.catchmind.admin.service.RestAdminApiLogicService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("owner")
public class OwnerController {

    @Autowired
    private PendingApiLogicService pendingApiLogicService;
    @Autowired
    private RestAdminApiLogicService restAdminApiLogicService;
    @Autowired
    private PaginationService paginationService;

    // 식당관리자 정보 출력
    @GetMapping("")
    public String ownerMain(@PageableDefault(size=10, sort="resaBisName", direction = Sort.Direction.DESC)Pageable pageable, ModelMap map) {
        Page<ResAdmin> resAdmins = restAdminApiLogicService.resAdminList(pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumber(pageable.getPageNumber(), resAdmins.getTotalPages());
        map.addAttribute("resAdmins", resAdmins);
        map.addAttribute("paginationBarNumbers", barNumbers);
        return "owner/owner";
    }


    // 식당관리자 검색
    @GetMapping("/")
    public ModelAndView searchMain(@RequestParam(value = "keyword")String keyword){
        ModelAndView view = new ModelAndView("owner/owner");
        view.addObject("list",restAdminApiLogicService.searchSome(keyword).getData());
        System.out.println(restAdminApiLogicService.searchSome(keyword));
        System.out.println(keyword);
        return view;
    }

    
    // 식당관리자 상세보기
    @GetMapping("/detail")
    public ModelAndView ownerDetail() {
        return new ModelAndView("owner/owner_detail");
    }

    // 입점문의
    @GetMapping("/new")
    public String newOwner(@PageableDefault(size=9, sort="penIdx", direction = Sort.Direction.DESC)Pageable pageable, ModelMap map) {
        Page<Pending> pendings = pendingApiLogicService.ownerlist(pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumber(pageable.getPageNumber(), pendings.getTotalPages());
        map.addAttribute("pendings", pendings);
        map.addAttribute("paginationBarNumbers", barNumbers);
        return "owner/new_owner";
    }

    // 입점문의 상세
    @GetMapping("/new/detail/{penIdx}")
    public ModelAndView newOwnerDetail(@PathVariable Long penIdx) {
        ModelAndView view = new ModelAndView("owner/new_owner_detail");
        Header<PendingApiResponse> api = pendingApiLogicService.read(penIdx);
        view.addObject("owner",api.getData());
        return view;
    }

}

