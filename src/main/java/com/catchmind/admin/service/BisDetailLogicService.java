package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.BistroDetail;
import com.catchmind.admin.model.entity.ResAdmin;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.BisDetailApiRequest;
import com.catchmind.admin.model.network.response.BisDetailApiResponse;
import com.catchmind.admin.repository.BisDetailRepository;
import com.catchmind.admin.repository.BistroInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BisDetailLogicService extends BaseService<BisDetailApiRequest, BisDetailApiResponse, BistroDetail> {
    private final BistroInfoRepository bistroInfoRepository;
    private final BisDetailRepository bisDetailRepository;

    private BisDetailApiResponse response(BistroDetail bistroDetail) {
        BisDetailApiResponse bisDetailApiResponse = BisDetailApiResponse.builder()
                .bdIdx(bistroDetail.getBdIdx())
                .bdNotice(bistroDetail.getBdNotice())
                .bdPark(bistroDetail.getBdPark())
                .bdAddr(bistroDetail.getBdAddr())
                .bdHp(bistroDetail.getBdHp())
                .bdIntro(bistroDetail.getBdIntro())
                .bdCaution(bistroDetail.getBdCaution())
                .bdHour(bistroDetail.getBdHour())
                .bdHoliday(bistroDetail.getBdHoliday())
                .bdHomepage(bistroDetail.getBdHomepage())
                .resaBisName(bistroDetail.getResAdmin().getResaBisName())
                .bisIdx(bistroDetail.getBisIdx())
                .build();
        return bisDetailApiResponse;
    }

    @Override
    public Header<BisDetailApiResponse> create(Header<BisDetailApiRequest> request) {
        BisDetailApiRequest bisDetailApiRequest = request.getData();
        String resaBisName = bisDetailApiRequest.getResaBisName();
        bistroInfoRepository.findByResAdmin_ResaBisName(resaBisName).ifPresent(
                searchUser -> bisDetailApiRequest.setBisIdx(searchUser.getBisIdx())
        );
        System.out.println("식당상세정보 입니다. : "+ bisDetailApiRequest.getBisIdx());
        BistroDetail bistroDetail = BistroDetail.builder()
                .resAdmin(ResAdmin.builder().resaBisName(bisDetailApiRequest.getResaBisName()).build())
                .bisIdx(bisDetailApiRequest.getBisIdx())
                .build();
        BistroDetail newBisDetail = bisDetailRepository.save(bistroDetail);
        return Header.OK(response(newBisDetail));
    }

    @Override
    public Header<BisDetailApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<BisDetailApiResponse> update(Header<BisDetailApiRequest> request) {
        return null;
    }

    @Override
    public Header<BisDetailApiResponse> delete(Long id) {
        return null;
    }
}
