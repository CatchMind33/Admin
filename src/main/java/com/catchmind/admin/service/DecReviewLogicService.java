package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.DeclareReview;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.DecReviewApiRequest;
import com.catchmind.admin.model.network.response.DecReviewApiResponse;
import com.catchmind.admin.repository.DecReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DecReviewLogicService extends BaseService<DecReviewApiRequest, DecReviewApiResponse, DeclareReview> {

    private final DecReviewRepository decReviewRepository;

    private DecReviewApiResponse response(DeclareReview declareReview) {
        DecReviewApiResponse reviewApiResponse = DecReviewApiResponse.builder()
                .derIdx(declareReview.getDerIdx())
                .revIdx(declareReview.getReview().getRevIdx())
                .derNick(declareReview.getDerNick())
                .prNick(declareReview.getPrNick())
                .derContent(declareReview.getDerContent())
                .revContent(declareReview.getReview().getRevContent())
                .regDate(declareReview.getRegDate())
                .resaBisName(declareReview.getReview().getResAdmin().getResaBisName())
                .build();
        return reviewApiResponse;
    }
    @Override
    public Header<DecReviewApiResponse> create(Header<DecReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<DecReviewApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<DecReviewApiResponse> update(Header<DecReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<DecReviewApiResponse> delete(Long id) {
        return null;
    }

    public Page<DecReviewApiResponse> list(Pageable pageable) {
        return decReviewRepository.findAll(pageable).map(review -> response(review));
    }
}
