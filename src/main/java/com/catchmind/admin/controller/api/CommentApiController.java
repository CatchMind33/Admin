package com.catchmind.admin.controller.api;

import com.catchmind.admin.controller.CrudController;
import com.catchmind.admin.model.entity.Comment;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.CommentApiRequest;
import com.catchmind.admin.model.network.response.CommentApiResponse;
import com.catchmind.admin.service.CommentApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")    // http://localhost:7070/api/restAdmin
@RequiredArgsConstructor
public class CommentApiController extends CrudController<CommentApiRequest, CommentApiResponse, Comment> {
    private final CommentApiLogicService commentApiLogicService;

    @GetMapping("/delete")
    public Header<CommentApiResponse> deleteok(@RequestParam("idx") Long idx, @RequestParam("revIdx") Long revIdx){
        return commentApiLogicService.deleteok(idx, revIdx);
    }

}
