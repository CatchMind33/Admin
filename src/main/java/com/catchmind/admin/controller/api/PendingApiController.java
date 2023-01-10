package com.catchmind.admin.controller.api;


import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.PendingApiRequest;
import com.catchmind.admin.model.network.response.PendingApiResponse;
import com.catchmind.admin.service.PendingApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pending")    // http://localhost:8888/api/restAdmin
@RequiredArgsConstructor
public class PendingApiController {

    private final PendingApiLogicService pendingApiLogicService;

    @PostMapping("/delete")
    public Header<PendingApiResponse> delete(@RequestBody Header<PendingApiRequest> request) {
        return pendingApiLogicService.deleteOk(request);
    }
}
