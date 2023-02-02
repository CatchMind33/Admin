package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.ResAdmin;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.ResAdminApiRequest;
import com.catchmind.admin.model.network.response.ResAdminApiResponse;
import com.catchmind.admin.repository.ResAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestAdminApiLogicService extends BaseService<ResAdminApiRequest, ResAdminApiResponse, ResAdmin>{

    private final ResAdminRepository restAdminRepository;

    private ResAdminApiResponse response(ResAdmin users){
        ResAdminApiResponse resAdminApiResponse = ResAdminApiResponse.builder()
                .resaUserid(users.getResaUserid())
                .resaUserpw(users.getResaUserpw())
                .resaName(users.getResaName())
                .resaHp(users.getResaHp())
                .resaRegion(users.getResaRegion())
                .resaBisName(users.getResaBisName())
                .regDate(users.getRegDate())
                .build();
        return resAdminApiResponse;
    }

    @Override
    public Header<ResAdminApiResponse> create(Header<ResAdminApiRequest> request) {
        ResAdminApiRequest resAdminApiRequest = request.getData();
        ResAdmin users = ResAdmin.builder().resaUserid(resAdminApiRequest.getResaUserid())
                .resaUserpw(resAdminApiRequest.getResaUserpw())
                .resaName(resAdminApiRequest.getResaName())
                .resaHp(resAdminApiRequest.getResaHp())
                .resaRegion(resAdminApiRequest.getResaRegion())
                .resaBisName(resAdminApiRequest.getResaBisName())
                .build();
        ResAdmin newUsers = restAdminRepository.save(users);
        return Header.OK(response(newUsers));
    }

    public Header<ResAdminApiResponse> insertInfo (String resaBisName){
        return null;
    }

    @Override
    public Header<ResAdminApiResponse> read(Long id) {
        return null;
    }

    @Transactional(readOnly = true)
    public Page<ResAdmin> resAdminList(Pageable pageable) {
        return restAdminRepository.findAll(pageable);
    }

    @Override
    public Header<ResAdminApiResponse> update(Header<ResAdminApiRequest> request) {
        return null;
    }

    @Override
    public Header<ResAdminApiResponse> delete(Long id) {
        return null;
    }

    public Header<List<ResAdminApiResponse>> search(Pageable pageable){
        Page<ResAdmin> users = restAdminRepository.findAll(pageable);
        List<ResAdminApiResponse> userApiResponses = users.stream().map(
                user -> response(user)).collect(Collectors.toList());

        return Header.OK(userApiResponses);
    }


    public Header deleteOk(String resaUserid) {
        Optional<ResAdmin> resAdmin = restAdminRepository.findByResaUserid(resaUserid);
        return resAdmin.map(deleteUser -> {
            restAdminRepository.delete(deleteUser);
            return Header.ok();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public Header<List<ResAdminApiResponse>> searchSome(String keyword) {
        List<ResAdmin> resAdmins = restAdminRepository.findByResaBisNameContaining(keyword);
        List<ResAdminApiResponse> userApiResponses = resAdmins.stream().map(
                user -> response(user)).collect(Collectors.toList());
        return Header.OK(userApiResponses);

    }
}
