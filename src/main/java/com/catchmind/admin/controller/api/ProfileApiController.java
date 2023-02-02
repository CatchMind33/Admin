package com.catchmind.admin.controller.api;

import com.catchmind.admin.controller.CrudController;
import com.catchmind.admin.model.entity.Profile;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.ProfileRequest;
import com.catchmind.admin.model.network.response.ProfileResponse;
import com.catchmind.admin.repository.ProfileRepository;
import com.catchmind.admin.service.ProfileLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class ProfileApiController extends CrudController<ProfileRequest, ProfileResponse, Profile> {
    private final ProfileLogicService profileLogicService;

    @GetMapping("/totalUser")
    public Header<List<ProfileResponse>> totalUser(@PageableDefault(sort={"prIdx"}, direction= Sort.Direction.DESC) Pageable pageable) {
        return profileLogicService.search(pageable);
    }

    @PostMapping(path="/memo")
    public Header<ProfileResponse> updateMemo(@RequestBody Header<ProfileRequest> request) {
        System.out.println(request.getData().getPrMemo());
        return profileLogicService.updateMemo(request);
    }

    @PostMapping("updatePoint")
    public Header<ProfileResponse> updatePoint(@RequestBody Header<ProfileRequest> request){
        return profileLogicService.updatePoint(request);
    }

}
