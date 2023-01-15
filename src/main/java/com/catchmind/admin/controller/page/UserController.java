package com.catchmind.admin.controller.page;

import com.catchmind.admin.model.entity.Profile;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.response.ProfileResponse;
import com.catchmind.admin.service.PaginationService;
import com.catchmind.admin.service.ProfileLogicService;
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

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final ProfileLogicService profileLogicService;
    private final PaginationService paginationService;

    @GetMapping("")
    public String totalUser(@PageableDefault(size=9, sort="prIdx", direction = Sort.Direction.DESC) Pageable pageable, ModelMap map) {
        Page<Profile> profiles = profileLogicService.list(pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumber(pageable.getPageNumber(), profiles.getTotalPages());
        map.addAttribute("profiles",profiles);
        map.addAttribute("paginationBarNumbers", barNumbers);
        return "user/user";
    }


    @GetMapping("/detail/{prIdx}")
    public ModelAndView userDetail(@PathVariable Long prIdx) {
        ModelAndView userDetail = new ModelAndView("user/user_detail");
        Header<ProfileResponse> user = profileLogicService.read(prIdx);
        userDetail.addObject("user",user.getData());
        return userDetail;
    }
}
