package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.Profile;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.ProfileRequest;
import com.catchmind.admin.model.network.response.ProfileResponse;
import com.catchmind.admin.repository.ProfileRepository;
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
public class ProfileLogicService extends BaseService<ProfileRequest, ProfileResponse, Profile> {


    private final ProfileRepository profileRepository;



    private ProfileResponse response(Profile profile) {
        ProfileResponse profileApiResponse = ProfileResponse.builder()
                .prIdx(profile.getPrIdx())
                .prName(profile.getPrName())
                .prNick(profile.getPrNick())
                .prRegion(profile.getPrRegion())
                .prHp(profile.getPrHp())
                .prGender(profile.getPrGender())
                .prMemo(profile.getPrMemo())
                .prNoshow(profile.getPrNoshow())
                .prBlock(profile.isPrBlock())
                .regDate(profile.getRegDate())
                .build();
        return profileApiResponse;
    }
    public Header<ProfileResponse> updateMemo(Header<ProfileRequest> request) {
        ProfileRequest profileRequest = request.getData();
        System.out.println(profileRequest.getPrIdx());
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

    public Header<ProfileResponse> updateBlock(Long prIdx, boolean prBlock){
        Optional<Profile> profile = profileRepository.findByPrIdx(prIdx);
        return profile.map(                        user->{
                    user.setPrBlock(prBlock);
                    return user;
                }).map(user-> baseRepository.save(user))
                .map(user->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

//    public Header<ProfileResponse> updatePoint(Long prIdx, Integer point){
//        Optional<Profile> profile = profileRepository.findByPrIdx(prIdx);
//        return profile.map(                        user->{
//                    user.setPrPoint(user.getPrPoint()+point);
//                    return user;
//                }).map(user-> baseRepository.save(user))
//                .map(user->response(user))
//                .map(Header::OK)
//                .orElseGet(()->Header.ERROR("데이터 없음"));
//    }

    @Override
    public Header<ProfileResponse> create(Header<ProfileRequest> request) {
        return null;
    }

    @Override
    public Header<ProfileResponse> read(Long id) {
        return profileRepository.findById(id).map(profile -> response(profile))
                .map(Header ::OK).orElseGet(()->Header.ERROR("데이터없음"));
    }

    public Header <List<ProfileResponse>> search(Pageable pageable) {
        Page<Profile> profiles = baseRepository.findAll(pageable);
        List<ProfileResponse> profileApiResponse = profiles.stream().map(
                profile -> response(profile)).collect(Collectors.toList());

        return Header.OK(profileApiResponse);
    }

    @Transactional(readOnly = true)
    public Page<Profile> list(Pageable pageable) {
        return profileRepository.findAll(pageable);
    }

    @Override
    public Header<ProfileResponse> update(Header<ProfileRequest> request) {
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

//    public Header<ProfileResponse> updatePoint(Header<ProfileRequest> request) {
//        ProfileRequest profileRequest = request.getData();
//        Optional<Profile> profiles = profileRepository.findByPrNick(profileRequest.getPrNick());
//        return profiles.map(
//                        profile -> {
//                            int pointTot = profiles.get().getPrPoint();
//                            profile.setPrPoint(profileRequest.getPrPoint()+pointTot);
//                            return profile;
//                        }).map(profile -> baseRepository.save(profile))
//                .map(profile -> response(profile))
//                .map(Header::OK)
//                .orElseGet(() -> Header.ERROR("데이터 없음")
//                );
//    }
}
