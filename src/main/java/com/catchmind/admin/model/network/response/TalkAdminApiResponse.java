package com.catchmind.admin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TalkAdminApiResponse {
    private Long taaIdx;
    private String taaNick;
    private String taaContent;
    private String regDate;
}
