package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.BistroInfo;
import com.catchmind.admin.model.entity.ResAdmin;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.BisInfoApiRequest;
import com.catchmind.admin.model.network.response.BisInfoApiResponse;
import com.catchmind.admin.repository.BistroInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BisInfoApiLogicService extends BaseService<BisInfoApiRequest, BisInfoApiResponse, BistroInfo> {

    private final BistroInfoRepository bistroInfoRepository;
    private BisInfoApiResponse response(BistroInfo bisInfo) {
        BisInfoApiResponse bisInfoApiResponse = BisInfoApiResponse.builder()
                .bisIdx(bisInfo.getBisIdx())
                .resaBisName(bisInfo.getResAdmin().getResaBisName())
                .bisDesc(bisInfo.getBisDesc())
                .bisCategory(bisInfo.getBisCategory())
                .bisRegion(bisInfo.getBisRegion())
                .bisLunch(bisInfo.getBisLunch())
                .bisDinner(bisInfo.getBisDinner())
                .bisConvenience(bisInfo.getBisConvenience())
                .regDate(bisInfo.getRegDate())
                .build();
        return bisInfoApiResponse;
    }
    @Override
    public Header<BisInfoApiResponse> create(Header<BisInfoApiRequest> request) {
        BisInfoApiRequest bisInfoApiRequest = request.getData();
        BistroInfo bistroInfo = BistroInfo.builder()
                .resAdmin(ResAdmin.builder().resaBisName(bisInfoApiRequest.getResaBisName()).build())
                .build();
        BistroInfo newBisInfo = bistroInfoRepository.save(bistroInfo);
        return Header.OK(response(newBisInfo));
    }

    @Override
    public Header<BisInfoApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<BisInfoApiResponse> update(Header<BisInfoApiRequest> request) {
        return null;
    }

    @Override
    public Header<BisInfoApiResponse> delete(Long id) {
        return null;
    }
}
