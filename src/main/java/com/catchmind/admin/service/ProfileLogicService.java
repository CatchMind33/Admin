package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.Admin;
import com.catchmind.admin.model.entity.Pending;
import com.catchmind.admin.model.entity.Profile;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.Pagination;
import com.catchmind.admin.model.network.request.ProfileRequest;
import com.catchmind.admin.model.network.response.AdminApiResponse;
import com.catchmind.admin.model.network.response.ProfileResponse;
import com.catchmind.admin.model.type.UserSortType;
import com.catchmind.admin.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileLogicService extends BaseService<ProfileRequest, ProfileResponse, Profile> {


    private final ProfileRepository profileRepository;

    private ProfileResponse response(Profile profile) {
        ProfileResponse profileResponse = ProfileResponse.builder()
                .prIdx(profile.getPrIdx())
                .prName(profile.getPrName())
                .prRegion(profile.getPrRegion())
                .prHp(profile.getPrHp())
                .prGender(profile.getPrGender())
                .prMemo(profile.getPrMemo())
                .prNoshow(profile.getPrNoshow())
                .prBlock(profile.isPrBlock())
                .build();
        return profileResponse;
    }
    @Override
    public Header<ProfileResponse> create(Header<ProfileRequest> request) {
        ProfileRequest profileRequest = request.getData();
        System.out.println("로직 :" + profileRequest.getPrMemo());
        Optional<Profile> users = baseRepository.findById(profileRequest.getPrIdx());

        return users.map(
                        user -> {
                            user.setPrMemo(profileRequest.getPrMemo());
                            return user;
                        }).map(user -> baseRepository.save(user))
                .map(user -> response(user))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음")
                );
    }

    @Override
    public Header<ProfileResponse> read(Long id) {
        return baseRepository.findById(id).map(user -> response(user))
                .map(Header ::OK).orElseGet(()->Header.ERROR("데이터없음"));
    }

    public Header <List<ProfileResponse>> search(Pageable pageable) {
        Page<Profile> profiles = baseRepository.findAll(pageable);
        List<ProfileResponse> ProfileResponse = profiles.stream().map(
                profile -> response(profile)).collect(Collectors.toList());

        Pagination pagination = Pagination.builder().totalPages(profiles.getTotalPages())
                .totalElements(profiles.getTotalElements())
                .currentPage(profiles.getNumber())
                .currentElements(profiles.getNumberOfElements())
                .build();
        return Header.OK(ProfileResponse, pagination);
    }

    @Transactional(readOnly = true)
    public Page<Profile> list(Pageable pageable) {
        return profileRepository.findAll(pageable);
    }

    @Override
    public Header<ProfileResponse> update(Header<ProfileResponse> request) {
        return null;
    }

    @Override
    public Header<ProfileResponse> delete(Long id) {
        return null;
    }

    public Long userCount() {
        Long cnt =  profileRepository.count();
        System.out.println(cnt);
        return cnt;
    }
}
