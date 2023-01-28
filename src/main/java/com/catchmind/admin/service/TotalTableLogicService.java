package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.ResAdmin;
import com.catchmind.admin.model.entity.TotalTable;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.TotalTableApiRequest;
import com.catchmind.admin.model.network.response.TotalTableApiResponse;
import com.catchmind.admin.repository.TotalTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TotalTableLogicService extends BaseService<TotalTableApiRequest, TotalTableApiResponse, TotalTable>{

    private final TotalTableRepository totalTableRepository;

    private TotalTableApiResponse response(TotalTable totalTable) {
        TotalTableApiResponse totalTableApiResponse = TotalTableApiResponse.builder()
                .totTableId(totalTable.getTotTableId())
                .resaBisName(totalTable.getResAdmin().getResaBisName())
                .totCapacity(totalTable.getTotCapacity())
                .totTable(totalTable.getTotTable())
                .build();
        return totalTableApiResponse;
    }
    @Override
    public Header<TotalTableApiResponse> create(Header<TotalTableApiRequest> request) {
        TotalTableApiRequest totalTableApiRequest = request.getData();
        TotalTable totalTable = TotalTable.builder()
                .resAdmin(ResAdmin.builder().resaBisName(totalTableApiRequest.getResaBisName()).build())
                .build();
        TotalTable newTotal = totalTableRepository.save(totalTable);
        return Header.OK(response(newTotal));
    }

    @Override
    public Header<TotalTableApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<TotalTableApiResponse> update(Header<TotalTableApiRequest> request) {
        return null;
    }

    @Override
    public Header<TotalTableApiResponse> delete(Long id) {
        return null;
    }
}
