package com.catchmind.admin.service;



import com.catchmind.admin.model.entity.Improvement;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.ImpApiRequest;
import com.catchmind.admin.model.network.response.ImpApiResponse;
import com.catchmind.admin.repository.ImpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImpApiLogicService extends BaseService<ImpApiRequest, ImpApiResponse, Improvement>{

    private final ImpRepository impRepository;

    private ImpApiResponse response(Improvement imp){
        ImpApiResponse impApiResponse = ImpApiResponse.builder()
                .impIdx(imp.getImpIdx())
                .impTitle(imp.getImpTitle())
                .impContent(imp.getImpContent())
                .prIdx(imp.getPrIdx())
                .impAnswer(imp.getImpAnswer())
                .build();
        return impApiResponse;
    }


    @Override
    public Header<ImpApiResponse> create(Header<ImpApiRequest> request) {
        ImpApiRequest impApiRequest = request.getData();

        Improvement imp = Improvement.builder()
                .impAnswer(impApiRequest.getImpAnswer())
                .build();
        Improvement newImp = baseRepository.save(imp);
        return Header.OK(response(newImp));
    }


    @Override
    public Header<ImpApiResponse> read(Long id) {
        return baseRepository.findById(id).map(imp -> response(imp))
                .map(Header::OK).orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<ImpApiResponse> update(Header<ImpApiRequest> request) {
        ImpApiRequest impApiRequest = request.getData();
        Optional<Improvement> imps = impRepository.findByImpIdx(impApiRequest.getImpIdx());

        return imps.map(
                        user -> {
                            user.setImpAnswer(impApiRequest.getImpAnswer());
                            user.setImpStatus(true);
                            return user;
                        }).map(user -> baseRepository.save(user))
                .map(user -> response(user))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음")
                );

    }


    @Override
    public Header<ImpApiResponse> delete(Long id) {
        return null;
    }



    public Page<Improvement> impList(Pageable pageable) {
        return impRepository.findAll(pageable);
    }




}
