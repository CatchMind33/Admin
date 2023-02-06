package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.DeclareComment;
import com.catchmind.admin.model.entity.Profile;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.DecComApiRequest;
import com.catchmind.admin.model.network.response.DecComApiResponse;
import com.catchmind.admin.repository.DecComRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DecComLogicService extends BaseService<DecComApiRequest, DecComApiResponse, DeclareComment> {

    private final DecComRepository decComRepository;

    private DecComApiResponse response(DeclareComment declareComment) {
        DecComApiResponse comApiResponse = DecComApiResponse.builder()
                .decIdx(declareComment.getDecIdx())
                .revIdx(declareComment.getReview().getRevIdx())
                .comIdx(declareComment.getComment().getComIdx())
                .decNick(declareComment.getDecNick())
                .resaBisName(declareComment.getReview().getResAdmin().getResaBisName())
                .decContent(declareComment.getDecContent())
                .comContent(declareComment.getComment().getComContent())
                .regDate(declareComment.getRegDate())
                .profile(Profile.builder().prIdx(declareComment.getProfile().getPrIdx()).build())
                .build();

        return comApiResponse;
    }

    @Override
    public Header<DecComApiResponse> create(Header<DecComApiRequest> request) {
        return null;
    }

    @Override
    public Header<DecComApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<DecComApiResponse> update(Header<DecComApiRequest> request) {
        return null;
    }

    @Override
    public Header<DecComApiResponse> delete(Long id) {
        return null;
    }

    public Page<DecComApiResponse> list(Pageable pageable) {
        return decComRepository.findAll(pageable).map(comment -> response(comment));
    }
}
