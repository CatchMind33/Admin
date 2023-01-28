package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.Review;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.ReviewApiRequest;
import com.catchmind.admin.model.network.response.ReviewApiResponse;
import com.catchmind.admin.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewLogicService extends BaseService<ReviewApiRequest, ReviewApiResponse, Review> {

    private final ReviewRepository reviewRepository;

    private ReviewApiResponse response(Review users){
        ReviewApiResponse reviewApiResponse = ReviewApiResponse.builder()
                .revIdx(users.getRevIdx())
                .revNick(users.getRevNick())
                .revLike(users.getRevLike())
                .revContent(users.getRevContent())
                .revScore(users.getRevScore())
                .resaBisName(users.getResAdmin().getResaBisName())
                .regDate(users.getRegDate())
                .updateDate(users.getUpdateDate())
                .build();
        return reviewApiResponse;
    }

    @Override
    public Header<ReviewApiResponse> create(Header<ReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<ReviewApiResponse> update(Header<ReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<ReviewApiResponse> delete(Long id) {
        return null;
    }

    @Override
    public Header<ReviewApiResponse> read(Long id) {
        return reviewRepository.findById(id).map(review -> response(review))
                .map(Header::OK).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public Page<ReviewApiResponse> reviewList(Pageable pageable) {
        return reviewRepository.findAll(pageable).map(review -> response(review));
    }
}
