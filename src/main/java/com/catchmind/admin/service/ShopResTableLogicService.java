package com.catchmind.admin.service;


import com.catchmind.admin.model.entity.ResAdmin;
import com.catchmind.admin.model.entity.ShopResTable;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.ShopResTableApiRequest;
import com.catchmind.admin.model.network.response.ShopResTableApiResponse;
import com.catchmind.admin.repository.ShopResRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopResTableLogicService extends BaseService<ShopResTableApiRequest, ShopResTableApiResponse, ShopResTable>{

    private final ShopResRepository shopResRepository;

    private ShopResTableApiResponse response (ShopResTable shopResTable) {
        ShopResTableApiResponse shopResTableApiResponse = ShopResTableApiResponse.builder()
                .shopResId(shopResTable.getShopResId())
                .shopResStatus(shopResTable.getShopResStatus())
                .shopResDate(shopResTable.getShopResDate())
                .shopResTime(shopResTable.getShopResTime())
                .resaBisName(shopResTable.getResAdmin().getResaBisName())
                .build();
        return shopResTableApiResponse;
    }
    @Override
    public Header<ShopResTableApiResponse> create(Header<ShopResTableApiRequest> request) {
        ShopResTableApiRequest shopResTableApiRequest = request.getData();
        ShopResTable shopResTable = ShopResTable.builder()
                .resAdmin(ResAdmin.builder().resaBisName(shopResTableApiRequest.getResaBisName()).build())
                .build();
        ShopResTable newShopRes = shopResRepository.save(shopResTable);
        return Header.OK(response(newShopRes));
    }

    @Override
    public Header<ShopResTableApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<ShopResTableApiResponse> update(Header<ShopResTableApiRequest> request) {
        return null;
    }

    @Override
    public Header<ShopResTableApiResponse> delete(Long id) {
        return null;
    }
}
