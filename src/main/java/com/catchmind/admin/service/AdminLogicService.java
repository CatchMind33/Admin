package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.Admin;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.AdminApiRequest;
import com.catchmind.admin.model.network.response.AdminApiResponse;
import com.catchmind.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminLogicService extends BaseService<AdminApiRequest, AdminApiResponse, Admin> {

    private final AdminRepository adminRepository;

    private AdminApiResponse response(Admin admin) {
        AdminApiResponse adminApiResponse = AdminApiResponse.builder()
                .adUserid(admin.getAdUserid())
                .adUserpw(admin.getAdUserpw())
                .adName(admin.getAdName())
                .adHp(admin.getAdHp())
                .adEmail(admin.getAdEmail())
                .build();
        return adminApiResponse;
    }

    @Override
    public Header<AdminApiResponse> create(Header<AdminApiRequest> request) {
        System.out.println("create : " + request.getData());
        AdminApiRequest adminApiRequest = request.getData();
        Admin admin = Admin.builder()
                .adUserid(adminApiRequest.getAdUserid())
                .adUserpw(adminApiRequest.getAdUserpw())
                .adName(adminApiRequest.getAdName())
                .adHp(adminApiRequest.getAdHp())
                .adEmail(adminApiRequest.getAdEmail())
                .build();
        Admin newAdmin = baseRepository.save(admin);
        return Header.OK(response(newAdmin));
    }

    @Override
    public Header<AdminApiResponse> read(Long id) {
        return null;
    }

    public Header<AdminApiResponse> read(String adUserid, String adUserpw) {
        return adminRepository.findByAdUseridAndAdUserpw(adUserid, adUserpw).map(
                        users -> response(users)).map(Header::OK)
                .orElseGet(() -> Header.ERROR("아이디또는 비번이 틀림")
                );
    }

    @Override
    public Header<AdminApiResponse> update(Header<AdminApiRequest> request) {
        return null;
    }

    @Override
    public Header<AdminApiResponse> delete(Long id) {
        return null;
    }

}
