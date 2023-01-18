package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.Notice;
import com.catchmind.admin.model.entity.Review;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.NoticeApiRequest;
import com.catchmind.admin.model.network.request.ReviewApiRequest;
import com.catchmind.admin.model.network.response.NoticeApiResponse;
import com.catchmind.admin.model.network.response.ReviewApiResponse;
import com.catchmind.admin.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewLogicService extends BaseService<ReviewApiRequest, ReviewApiResponse, Review> {

    private final ReviewRepository reviewRepository;

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

//    @Override
//    public Header delete(Long revIdx) {
//        Optional<Review> reviews = baseRepository.findById(revIdx);
//        return reviews.map(review -> {
//            baseRepository.delete(review);
//            return Header.ok();
//        }).orElseGet(() -> Header.ERROR("데이터 없음"));
//    }

    private ReviewApiResponse response(Review users){
        ReviewApiResponse reviewApiResponse = ReviewApiResponse.builder()
                .revIdx(users.getRevIdx())
                .revNick(users.getRevNick())
                .revLike(users.getRevLike())
                .revContent(users.getRevContent())
                .revScore(users.getRevScore())
                .resaBisName(users.getResaBisName())
                .build();
        return reviewApiResponse;
    }

    /*ㅎㅇㅎㅇ*/

    @Override
    public Header<ReviewApiResponse> read(Long id) {
        return baseRepository.findById(id).map(review -> response(review))
                .map(Header::OK).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public List<Review> reviewList() {
        return reviewRepository.findAll();
    }
}
