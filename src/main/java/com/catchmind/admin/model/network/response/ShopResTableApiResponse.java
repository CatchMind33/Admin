package com.catchmind.admin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopResTableApiResponse {
    private Long shopResId;
    private String shopResStatus;
    private String shopResMonth;
    private String shopResDay;
    private String shopResTime;
    private String resaBisName;
}
