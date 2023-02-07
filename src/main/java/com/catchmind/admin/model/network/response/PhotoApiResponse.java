package com.catchmind.admin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoApiResponse {
    private Long phIdx;
    private String orgNm;
    private String savedNm;
    private String savedPath;
    private String type;
    private String resaBisName;
}
