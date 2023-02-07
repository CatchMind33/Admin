package com.catchmind.admin.controller.api;

import com.catchmind.admin.controller.CrudController;
import com.catchmind.admin.model.entity.Point;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.PointApiRequest;
import com.catchmind.admin.model.network.response.PointApiResponse;
import com.catchmind.admin.service.PointApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/point")    // http://localhost:8888/api/restAdmin
@RequiredArgsConstructor
public class PointApiController extends CrudController<PointApiRequest, PointApiResponse, Point> {

    private final PointApiLogicService pointApiLogicService;

//    @Override
//    @PostMapping("")
//    public Header<PointApiResponse> create(@RequestBody Header<PointApiRequest> request) {
//        return pointApiLogicService.create(request);
//    }

    @GetMapping("/createlist")
    public Header<PointApiResponse> createlist(@RequestParam("idx") Long id,@RequestParam("list") String list){
        return pointApiLogicService.createlist(id, list);
    }

}
