package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.ResAdmin;
import com.catchmind.admin.model.entity.TalkAdmin;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.ResAdminApiRequest;
import com.catchmind.admin.model.network.request.TalkAdminApiRequest;
import com.catchmind.admin.model.network.response.ResAdminApiResponse;
import com.catchmind.admin.model.network.response.TalkAdminApiResponse;
import com.catchmind.admin.repository.TalkAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TalkAdminApiLogicService extends BaseService<TalkAdminApiRequest, TalkAdminApiResponse, TalkAdmin>{

    public final TalkAdminRepository talkAdminRepository;

    @Override
    public Header<TalkAdminApiResponse> create(Header<TalkAdminApiRequest> request) {
        return null;
    }

    @Override
    public Header<TalkAdminApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<TalkAdminApiResponse> update(Header<TalkAdminApiRequest> request) {
        return null;
    }

    @Override
    public Header<TalkAdminApiResponse> delete(Long id) {
        return null;
    }

    public List<TalkAdmin> msgList() {
        return talkAdminRepository.findAll();
    }
}
