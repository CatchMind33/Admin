package com.catchmind.admin.controller.page;

import com.catchmind.admin.model.entity.Pending;
import com.catchmind.admin.model.entity.ResAdmin;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.response.PendingApiResponse;
import com.catchmind.admin.repository.ResAdminRepository;
import com.catchmind.admin.repository.ReserveRepository;
import com.catchmind.admin.service.PaginationService;
import com.catchmind.admin.service.PendingApiLogicService;
import com.catchmind.admin.service.RestAdminApiLogicService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("owner")
@RequiredArgsConstructor
public class OwnerController {

    private final PendingApiLogicService pendingApiLogicService;
    private final RestAdminApiLogicService restAdminApiLogicService;
    private final PaginationService paginationService;
    private final ResAdminRepository resAdminRepository;
    private final ReserveRepository reserveRepository;


    // 식당관리자 정보 출력
    @GetMapping("")
    public String ownerMain(@PageableDefault(size=10, sort="resaBisName", direction = Sort.Direction.DESC)Pageable pageable, ModelMap map, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {
            return "login";
        } else {
            userid= (String)session.getAttribute("userid");
            name= (String)session.getAttribute("name");
        }
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
    @GetMapping("/detail/{resaBisName}")
    public ModelAndView ownerDetail(@PathVariable String resaBisName, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {
            return new ModelAndView("login");
        } else {
            userid= (String)session.getAttribute("userid");
            name= (String)session.getAttribute("name");
        }
        Optional<ResAdmin> resAdmin = resAdminRepository.findByResaBisName(resaBisName);
        ResAdmin resadmin = resAdmin.get();
        String status1 = "DONE";
        String status2 = "PLANNED";
        String status3 = "CANCEL";
        Integer done = reserveRepository.countReserveByResStatusAndResaBisName(status1,resaBisName);
        Integer planned = reserveRepository.countReserveByResStatusAndResaBisName(status2,resaBisName);
        Integer cancel = reserveRepository.countReserveByResStatusAndResaBisName(status3,resaBisName);
        System.out.println(done);
        System.out.println(planned);
        System.out.println(cancel);
        Integer reserve = done+planned;
        ModelAndView view = new ModelAndView("owner/owner_detail");
        System.out.println(resAdmin);
        view.addObject("resadmin",resadmin)
                .addObject("reserve",reserve)
                .addObject("cancel",cancel);
        return view;
    }

    // 입점문의
    @GetMapping("/new")
    public String newOwner(@PageableDefault(size=9, sort="penIdx", direction = Sort.Direction.DESC)Pageable pageable, ModelMap map, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {
            return "login";
        } else {
            userid= (String)session.getAttribute("userid");
            name= (String)session.getAttribute("name");
        }
        Page<Pending> pendings = pendingApiLogicService.ownerlist(pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumber(pageable.getPageNumber(), pendings.getTotalPages());
        map.addAttribute("pendings", pendings);
        map.addAttribute("paginationBarNumbers", barNumbers);
        return "owner/new_owner";
    }

    // 입점문의 상세
    @GetMapping("/new/detail/{penIdx}")
    public ModelAndView newOwnerDetail(@PathVariable Long penIdx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {
            return new ModelAndView("login");
        } else {
            userid= (String)session.getAttribute("userid");
            name= (String)session.getAttribute("name");
        }
        ModelAndView view = new ModelAndView("owner/new_owner_detail");
        Header<PendingApiResponse> api = pendingApiLogicService.read(penIdx);
        view.addObject("owner",api.getData());
        return view;
    }

}

