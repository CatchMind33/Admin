package com.catchmind.admin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeApiResponse {

    private Long noIdx;
    private String noTitle;
    private String adName;
    private String adUserid;
    private String noContent;

}
