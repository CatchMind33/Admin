package com.catchmind.admin.model.network.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeApiRequest {
    private String noTitle;
    private String noContent;
    private Long noIdx;


}
