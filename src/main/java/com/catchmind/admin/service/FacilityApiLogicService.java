package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.Facility;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.FacilityApiRequest;
import com.catchmind.admin.model.network.response.FacilityApiResponse;
import com.catchmind.admin.repository.BistroInfoRepository;
import com.catchmind.admin.repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacilityApiLogicService extends BaseService<FacilityApiRequest, FacilityApiResponse, Facility>{
    private final FacilityRepository facilityRepository;
    private final BistroInfoRepository bistroInfoRepository;

    private FacilityApiResponse response(Facility facility) {
        FacilityApiResponse facilityApiResponse = FacilityApiResponse.builder()
                .facIdx(facility.getFacIdx())
                .bisIdx(facility.getBisIdx())
                .resaBisName(facility.getResaBisName())
                .facParking(facility.isFacParking())
                .facValet(facility.isFacValet())
                .facCorkage(facility.isFacCorkage())
                .facNokid(facility.isFacNokid())
                .facAnimal(facility.isFacAnimal())
                .facHandi(facility.isFacHandi())
                .build();
        return facilityApiResponse;
    }
    @Override
    public Header<FacilityApiResponse> create(Header<FacilityApiRequest> request) {
        FacilityApiRequest facilityApiRequest = request.getData();
        String resaBisName = facilityApiRequest.getResaBisName();
        bistroInfoRepository.findByResAdmin_ResaBisName(resaBisName).ifPresent(
                searchUser -> facilityApiRequest.setBisIdx(searchUser.getBisIdx())
        );
        System.out.println("편의시설입니다 : " + facilityApiRequest.getBisIdx());
        Facility facility = Facility.builder()
                .resaBisName(facilityApiRequest.getResaBisName())
                .bisIdx(facilityApiRequest.getBisIdx())
                .build();
        Facility newFacility = facilityRepository.save(facility);
        return Header.OK(response(newFacility));
    }

    @Override
    public Header<FacilityApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<FacilityApiResponse> update(Header<FacilityApiRequest> request) {
        return null;
    }

    @Override
    public Header<FacilityApiResponse> delete(Long id) {
        return null;
    }
}
