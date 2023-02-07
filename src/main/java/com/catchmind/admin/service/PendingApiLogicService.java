package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.Pending;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.PendingApiRequest;
import com.catchmind.admin.model.network.response.PendingApiResponse;
import com.catchmind.admin.repository.PendingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PendingApiLogicService extends BaseService<PendingApiRequest, PendingApiResponse, Pending>{

    public final PendingRepository pendingRepository;

    private PendingApiResponse response(Pending users){
        PendingApiResponse pendingApiResponse = PendingApiResponse.builder()
                .penIdx(users.getPenIdx())
                .penBisName(users.getPenBisName())
                .penHp(users.getPenHp())
                .penName(users.getPenName())
                .penFoodtype(users.getPenFoodtype())
                .penRegion(users.getPenRegion())
                .penBook(users.getPenBook())
                .regDate(users.getRegDate())
                .build();
        return pendingApiResponse;
    }

    @Override
    public Header<PendingApiResponse> create(Header<PendingApiRequest> request) {
        return null;
    }

    @Override
    public Header<PendingApiResponse> read(Long meIdx) {
        return baseRepository.findById(meIdx).map(pending -> response(pending))
                .map(Header::OK).orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<PendingApiResponse> update(Header<PendingApiRequest> request) {
        return null;
    }

    @Override
    public Header<PendingApiResponse> delete(Long id) {
        return null;
    }

    public Header deleteOk(Header<PendingApiRequest> request) {
        PendingApiRequest pendingApiRequest = request.getData();

        Optional<Pending> users = pendingRepository.findByPenBisName(pendingApiRequest.getPenBisName());
        return users.map(user ->{
            baseRepository.delete(user);
            return Header.ok();
        }).orElseGet(() -> Header.ERROR("데이터없음"));
    }

    public Page<Pending> ownerlist(Pageable pageable) {
        return pendingRepository.findAll(pageable);
    }
    public Header deletepend(String penBisname){
        Optional<Pending> pendingApiResponse = pendingRepository.findByPenBisName(penBisname);
        return  pendingApiResponse.map(user->{
            pendingRepository.delete(user);
            return Header.ok();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }
}
