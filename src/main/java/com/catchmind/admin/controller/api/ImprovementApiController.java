package com.catchmind.admin.controller.api;

import com.catchmind.admin.controller.CrudController;
import com.catchmind.admin.model.entity.Improvement;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.ImpApiRequest;
import com.catchmind.admin.model.network.response.ImpApiResponse;
import com.catchmind.admin.service.ImpApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/impapi")
@RequiredArgsConstructor
public class ImprovementApiController extends CrudController<ImpApiRequest, ImpApiResponse, Improvement> {

    private final ImpApiLogicService impApiLogicService;

    @Override
    @PostMapping("/imp")
    public Header<ImpApiResponse> create(@RequestBody Header<ImpApiRequest> request){
        System.out.println(request.getData());
        return impApiLogicService.create(request);
    }


    @Override
    @GetMapping("{impIdx}") // http://localhost:8888/api/user/{id} (get)
    public Header<ImpApiResponse> read(@PathVariable(name="impIdx") Long id) {
        return impApiLogicService.read(id);
    }

    @Override
    @PostMapping ("{impIdx}") // http://localhost:9999/api/
    public Header<ImpApiResponse> update(@RequestBody Header<ImpApiRequest> request) {
        System.out.println("requestgetdata: " + request.getData());
        return impApiLogicService.update(request);
    }


    @Override
    public Header<ImpApiResponse> delete(Long id) {
        return super.delete(id);
    }



}
