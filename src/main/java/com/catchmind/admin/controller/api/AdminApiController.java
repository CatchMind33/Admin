package com.catchmind.admin.controller.api;

import com.catchmind.admin.controller.CrudController;
import com.catchmind.admin.model.entity.Admin;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.AdminApiRequest;
import com.catchmind.admin.model.network.response.AdminApiResponse;
import com.catchmind.admin.service.AdminLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AdminApiController extends CrudController<AdminApiRequest, AdminApiResponse, Admin> {

    private final AdminLogicService adminLogicService;

    @Override
    @PostMapping("/join")
    public Header<AdminApiResponse> create(@RequestBody Header<AdminApiRequest> request) {
        System.out.println(request.getData());
       return adminLogicService.create(request);
    }

    @Override
    public Header<AdminApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    public Header<AdminApiResponse> update(Header<AdminApiRequest> request) {
        return super.update(request);
    }

    @Override
    public Header<AdminApiResponse> delete(Long id) {
        return super.delete(id);
    }
}
