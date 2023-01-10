package com.catchmind.admin.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminApiRequest {
    private Long adIdx;
    private String adUserid;
    private String adUserpw;
    private String adName;
    private String adHp;
    private String adEmail;

}
