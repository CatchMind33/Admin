package com.catchmind.admin.controller.api;

import com.catchmind.admin.controller.CrudController;
import com.catchmind.admin.model.entity.Ask;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.AskApiRequest;
import com.catchmind.admin.model.network.response.AskApiResponse;
import com.catchmind.admin.service.AskApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/askapi")
@RequiredArgsConstructor
public class AskApiController extends CrudController<AskApiRequest, AskApiResponse, Ask> {

    private final AskApiLogicService askApiLogicService;

    @Override
    @PostMapping("/ask")
    public Header<AskApiResponse> create(@RequestBody Header<AskApiRequest> request){
        System.out.println(request.getData());
        return askApiLogicService.create(request);
    }


    @Override
    @GetMapping("{askIdx}") // http://localhost:8888/api/user/{id} (get)
    public Header<AskApiResponse> read(@PathVariable(name="askIdx") Long id) {
        return askApiLogicService.read(id);
    }

    @Override
    @PostMapping ("{askIdx}") // http://localhost:9999/api/
    public Header<AskApiResponse> update(@RequestBody Header<AskApiRequest> request) {
        System.out.println("requestgetdata: " + request.getData());
        return askApiLogicService.update(request);
    }

    @Override
    public Header<AskApiResponse> delete(Long id) {
        return super.delete(id);
    }



}
