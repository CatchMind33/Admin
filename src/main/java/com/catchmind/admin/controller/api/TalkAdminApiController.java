package com.catchmind.admin.controller.api;

import com.catchmind.admin.controller.CrudController;
import com.catchmind.admin.model.entity.TalkAdmin;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.TalkAdminApiRequest;
import com.catchmind.admin.model.network.response.TalkAdminApiResponse;
import com.catchmind.admin.service.TalkAdminApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/talkAdmin")
@RequiredArgsConstructor
public class TalkAdminApiController extends CrudController<TalkAdminApiRequest, TalkAdminApiResponse, TalkAdmin> {
    private final TalkAdminApiLogicService talkAdminApiLogicService;

    @PostMapping("/noShow")
    public Header<TalkAdminApiResponse> noShow(@RequestBody Header<TalkAdminApiRequest> request) {
        System.out.println(request.getData());
        return talkAdminApiLogicService.createProfile(request);
    }

    @PostMapping("/pending")
    public Header<TalkAdminApiResponse> pending(@RequestBody Header<TalkAdminApiRequest> request) {
        System.out.println(request.getData());
        return talkAdminApiLogicService.createPending(request);
    }
}
