package com.catchmind.admin.service;


import com.catchmind.admin.model.entity.Ask;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.AskApiRequest;
import com.catchmind.admin.model.network.response.AskApiResponse;
import com.catchmind.admin.repository.AskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AskApiLogicService extends BaseService<AskApiRequest, AskApiResponse, Ask> {

    private final AskRepository askRepository;

    private AskApiResponse response(Ask ask){
        AskApiResponse askApiResponse = AskApiResponse.builder()
        .askIdx(ask.getAskIdx())
        .askTitle(ask.getAskTitle())
        .askContent(ask.getAskContent())
        .askAnswer(ask.getAskAnswer()).prIdx(ask.getPrIdx()).askStatus(ask.isAskStatus())
        .build();
        return askApiResponse;
    }


    @Override
    public Header<AskApiResponse> create(Header<AskApiRequest> request) {
        AskApiRequest askApiRequest = request.getData();

        Ask ask = Ask.builder()
                .askAnswer(askApiRequest.getAskAnswer())
                .askStatus(true)
                .build();
        Ask newAsk = baseRepository.save(ask);
        return Header.OK(response(newAsk));
    }


    @Override
    public Header<AskApiResponse> read(Long id) {
        return baseRepository.findById(id).map(ask -> response(ask))
                .map(Header::OK).orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<AskApiResponse> update(Header<AskApiRequest> request) {
        AskApiRequest askApiRequest = request.getData();
            Optional<Ask> asks = askRepository.findByAskIdx(askApiRequest.getAskIdx());
            return asks.map(
                            user -> {
                                user.setAskAnswer(askApiRequest.getAskAnswer());
                                user.setAskStatus(true);
                                return user;
                            }).map(user -> baseRepository.save(user))
                    .map(user -> response(user))
                    .map(Header::OK)
                    .orElseGet(() -> Header.ERROR("데이터 없음")
                    );

    }
//    @Override
//    public Header<AskApiResponse> update(Header<AskApiRequest> request) {
//        AskApiRequest askApiRequest = request.getData();
//
//        Ask ask = Ask.builder()
//                .askAnswer(askApiRequest.getAskAnswer())
//                .build();
//        Ask newAsk = baseRepository.save(ask);
//        return Header.OK(response(newAsk));
//    }

    @Override
    public Header<AskApiResponse> delete(Long id) {
        return null;
    }



    @Transactional(readOnly = true)
    public Page<Ask> askList(Pageable pageable) {
        return askRepository.findAll(pageable);
    }



}


