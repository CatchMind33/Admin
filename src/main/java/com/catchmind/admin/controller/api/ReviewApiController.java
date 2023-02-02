package com.catchmind.admin.controller.api;

import com.catchmind.admin.controller.CrudController;
import com.catchmind.admin.model.entity.Review;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.ReviewApiRequest;
import com.catchmind.admin.model.network.response.ReviewApiResponse;
import com.catchmind.admin.service.ReviewLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/review")    // http://localhost:7070/api/restAdmin
@RequiredArgsConstructor
public class ReviewApiController extends CrudController<ReviewApiRequest, ReviewApiResponse, Review> {
    private final ReviewLogicService reviewLogicService;

    @GetMapping("/delete")
    public Header<ReviewApiResponse> deleteok(@RequestParam("idx") Long idx){
        return reviewLogicService.deleteok(idx);
    }

}
