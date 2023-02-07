package com.catchmind.admin.controller.api;

import com.catchmind.admin.controller.CrudController;
import com.catchmind.admin.model.entity.ResAdmin;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.*;
import com.catchmind.admin.model.network.response.*;
import com.catchmind.admin.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restAdmin")    // http://localhost:7070/api/restAdmin
@RequiredArgsConstructor
public class RestAdminApiController extends CrudController<ResAdminApiRequest, ResAdminApiResponse, ResAdmin> {
    private final RestAdminApiLogicService restAdminApiLogicService;
    private final BisInfoApiLogicService bisInfoApiLogicService;
    private final BisDetailLogicService bisDetailLogicService;
    private final TotalTableLogicService totalTableLogicService;
    private final PhotoApiLogicService photoApiLogicService;
    private final FacilityApiLogicService facilityApiLogicService;

    @PostMapping("")
    public Header<ResAdminApiResponse> create(@RequestBody Header<ResAdminApiRequest> request) {
        return restAdminApiLogicService.create(request);
    }

    @DeleteMapping("delete/{resaUserid}")
    public Header deleteOk(@PathVariable String resaUserid) {
        return restAdminApiLogicService.deleteOk(resaUserid);
    }

    @PostMapping("/bistro")
    public Header<BisInfoApiResponse> insert(@RequestBody Header<BisInfoApiRequest> request) {
       return bisInfoApiLogicService.create(request);
    }

    @PostMapping("/detail")
    public Header<BisDetailApiResponse> detail(@RequestBody Header<BisDetailApiRequest> request) {
        return bisDetailLogicService.create(request);
    }

    @PostMapping("/total")
    public Header<TotalTableApiResponse> total(@RequestBody Header<TotalTableApiRequest> request) {
        return totalTableLogicService.create(request);
    }

    @PostMapping("/fac")
    public Header<FacilityApiResponse> fac(@RequestBody Header<FacilityApiRequest> request) {
        return facilityApiLogicService.create(request);
    }

    @PostMapping("/photo")
    public Header<PhotoApiResponse> photo(@RequestBody Header<PhotoApiRequest> request) {
        return photoApiLogicService.create(request);
    }

}
