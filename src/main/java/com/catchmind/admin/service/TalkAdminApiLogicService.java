package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.Profile;
import com.catchmind.admin.model.entity.TalkAdmin;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.TalkAdminApiRequest;
import com.catchmind.admin.model.network.response.TalkAdminApiResponse;
import com.catchmind.admin.repository.ProfileRepository;
import com.catchmind.admin.repository.TalkAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TalkAdminApiLogicService extends BaseService<TalkAdminApiRequest, TalkAdminApiResponse, TalkAdmin>{

    public final TalkAdminRepository talkAdminRepository;
    private final ProfileRepository profileRepository;

    private TalkAdminApiResponse response (TalkAdmin talkAdmin ) {
        TalkAdminApiResponse talkAdminApiResponse = TalkAdminApiResponse.builder()
                .taaIdx(talkAdmin.getTaaIdx())
                .taaContent(talkAdmin.getTaaContent())
                .regDate(talkAdmin.getRegDate())
                .prIdx(talkAdmin.getPrIdx())
                .build();
        return talkAdminApiResponse;
    }

    @Override
    public Header<TalkAdminApiResponse> create(Header<TalkAdminApiRequest> request) {
        return null;
    }

    public Header<TalkAdminApiResponse> createProfile(Header<TalkAdminApiRequest> request) {
        TalkAdminApiRequest talkAdminApiRequest = request.getData();
        TalkAdmin talkAdmin = TalkAdmin.builder()
                .taaContent(talkAdminApiRequest.getTaaContent())
                .build();
        TalkAdmin newMsg = baseRepository.save(talkAdmin);
        return Header.ok();
    }

    public Header<TalkAdminApiResponse> msg(String taaContent,String derNick){
//        String derNick= request.getDerNick();
//        String content = request.getTaaContent();
        Profile profile = profileRepository.findByPrNick(derNick).orElseThrow();
        Long prIdx = profile.getPrIdx();

        TalkAdmin talkAdmin = TalkAdmin.builder()
                .prIdx(prIdx)
                .taaContent(taaContent)
                .build();
        TalkAdmin newMsg = baseRepository.save(talkAdmin);
        return Header.ok();
    }
    public Header<TalkAdminApiResponse> createmsg(String taaContent, Long prIdx){
        TalkAdmin talkAdmin = TalkAdmin.builder()
                .prIdx(prIdx)
                .taaContent(taaContent)
                .build();
        TalkAdmin newMsg = baseRepository.save(talkAdmin);
        return Header.ok();
    }

    public Header<TalkAdminApiResponse> createPending(Header<TalkAdminApiRequest> request) {
        TalkAdminApiRequest talkAdminApiRequest = request.getData();
        TalkAdmin talkAdmin = TalkAdmin.builder()
                .taaContent(talkAdminApiRequest.getTaaContent())
                .build();
        TalkAdmin newMsg = baseRepository.save(talkAdmin);
        return Header.ok();
    }
    @Override
    public Header<TalkAdminApiResponse> read(Long id) {
        return talkAdminRepository.findById(id).map(talks -> Header.OK(response(talks))).orElseGet(() -> Header.ERROR("데이터없음"));
    }

    @Override
    public Header<TalkAdminApiResponse> update(Header<TalkAdminApiRequest> request) {
        return null;
    }

    @Override
    public Header<TalkAdminApiResponse> delete(Long id) {
        return null;
    }

    public Page<TalkAdminApiResponse> msgList(Pageable pageable) {
        return talkAdminRepository.findAll(pageable).map(msg -> response(msg));
    }
}
