package com.catchmind.admin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminApiResponse {
    private Long adIdx;
    private String adUserid;
    private String adUserpw;
    private String adName;
    private String adHp;
    private String adEmail;
    private String regDate;
}
