package com.catchmind.admin.controller.page;

import com.catchmind.admin.controller.api.RestAdminApiController;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.response.NoticeApiResponse;
import com.catchmind.admin.model.network.response.PendingApiResponse;
import com.catchmind.admin.repository.PendingRepository;
import com.catchmind.admin.service.PendingApiLogicService;
import com.catchmind.admin.service.RestAdminApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("")
    public ModelAndView ownerMain() {
        ModelAndView view = new ModelAndView("owner/owner");
        System.out.println(restAdminApiLogicService.resAdminList());
        view.addObject("list", restAdminApiLogicService.resAdminList());
        return view;
    }

    @GetMapping("/")
    public ModelAndView searchMain(@RequestParam(value = "keyword")String keyword){
        ModelAndView view = new ModelAndView("owner/owner");
        view.addObject("list",restAdminApiLogicService.searchSome(keyword).getData());
        System.out.println(restAdminApiLogicService.searchSome(keyword));
        System.out.println(keyword);
        return view;
    }

    @GetMapping("/detail")
    public ModelAndView ownerDetail() {
        return new ModelAndView("owner/owner_detail");
    }

    @GetMapping("/new")
    public ModelAndView newOwner() {
        ModelAndView view = new ModelAndView("owner/new_owner");
        view.addObject("list", pendingApiLogicService.ownerlist());
        System.out.println(pendingApiLogicService.ownerlist());
        return view;
    }

    @GetMapping("/new/detail/{penIdx}")
    public ModelAndView newOwnerDetail(@PathVariable Long penIdx) {
        ModelAndView view = new ModelAndView("owner/new_owner_detail");
        Header<PendingApiResponse> api = pendingApiLogicService.read(penIdx);
        view.addObject("owner",api.getData());
        return view;
    }

}

