package com.catchmind.admin.controller.api;

import com.catchmind.admin.controller.CrudController;
import com.catchmind.admin.model.entity.Notice;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.NoticeApiRequest;
import com.catchmind.admin.model.network.response.NoticeApiResponse;
import com.catchmind.admin.service.NoticeApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NoticeApiController extends CrudController<NoticeApiRequest,NoticeApiResponse, Notice> {

    private final NoticeApiLogicService noticeApiLogicService;

    @Override
    @PostMapping("/notice")
    public Header<NoticeApiResponse> create(@RequestBody Header<NoticeApiRequest> request){
        System.out.println(request.getData());
        return noticeApiLogicService.create(request);
    }


    @Override
    @GetMapping("{noIdx}") // http://localhost:8888/api/user/{id} (get)
    public Header<NoticeApiResponse> read(@PathVariable(name="noIdx") Long id) {
        return noticeApiLogicService.read(id);
    }

    @Override
    @PostMapping ("") // http://localhost:9999/api/  (put)
    public Header<NoticeApiResponse> update(@RequestBody Header<NoticeApiRequest> request) {
        return noticeApiLogicService.update(request);
    }
//

    @Override
    @DeleteMapping("/delete/{noIdx}") // http://localhost: (delete)
    public Header<NoticeApiResponse> delete(@PathVariable(name="noIdx") Long id) {
        return noticeApiLogicService.delete(id);
    }


}
