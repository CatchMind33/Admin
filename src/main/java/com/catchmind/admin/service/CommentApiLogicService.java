package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.Comment;
import com.catchmind.admin.model.entity.Review;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.CommentApiRequest;
import com.catchmind.admin.model.network.response.CommentApiResponse;
import com.catchmind.admin.repository.CommentRepository;
import com.catchmind.admin.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentApiLogicService extends BaseService<CommentApiRequest, CommentApiResponse, Comment> {
    private final CommentRepository commentRepository;
    private final ReviewRepository reviewRepository;

    private CommentApiResponse response(Comment comment){
        CommentApiResponse commentApiResponse = CommentApiResponse.builder().comIdx(comment.getComIdx())
                .revIdx(comment.getRevIdx()).comContent(comment.getComContent()).revIdx(comment.getRevIdx()).build();
        return commentApiResponse;
    }

    @Override
    public Header<CommentApiResponse> create(Header<CommentApiRequest> request) {
        return null;
    }

    @Override
    public Header<CommentApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<CommentApiResponse> update(Header<CommentApiRequest> request) {
        return null;
    }

    @Override
    public Header<CommentApiResponse> delete(Long id) {
        return null;
    }

    public Header deleteok(Long idx, Long revIdx){
        Long revComm = reviewRepository.findById(revIdx).get().getRevComm();
        revComm -= 1;
        Review review = reviewRepository.findById(revIdx).orElseThrow();
        review.setRevComm(revComm);
        reviewRepository.save(review);
        Optional<Comment> comment = commentRepository.findByComIdx(idx);
        return comment.map(user->{
            commentRepository.delete(user);
            return Header.ok();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
        }
    }
