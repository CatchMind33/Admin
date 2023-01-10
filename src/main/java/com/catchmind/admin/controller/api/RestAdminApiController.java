package com.catchmind.admin.controller.api;

import com.catchmind.admin.controller.CrudController;
import com.catchmind.admin.model.entity.ResAdmin;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.ResAdminApiRequest;
import com.catchmind.admin.model.network.response.ResAdminApiResponse;
import com.catchmind.admin.service.RestAdminApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restAdmin")    // http://localhost:8888/api/restAdmin
@RequiredArgsConstructor
public class RestAdminApiController extends CrudController<ResAdminApiRequest, ResAdminApiResponse, ResAdmin> {
    private final RestAdminApiLogicService restAdminApiLogicService;

    @Override
    @PostMapping("")
    public Header<ResAdminApiResponse> create(@RequestBody Header<ResAdminApiRequest> request) {
        return restAdminApiLogicService.create(request);
    }

//    @GetMapping("/search")
//    public Header<List<ResAdminApiResponse>> findSome(@RequestParam(value = "keyword")String keyword){
//        System.out.println(restAdminApiLogicService.searchSome(keyword));
//        System.out.println(keyword);
//        return restAdminApiLogicService.searchSome(keyword);
//    }

    @DeleteMapping("delete/{resaUserid}")
    public Header deleteOk(@PathVariable String resaUserid){
        return restAdminApiLogicService.deleteOk(resaUserid);
    }

}
