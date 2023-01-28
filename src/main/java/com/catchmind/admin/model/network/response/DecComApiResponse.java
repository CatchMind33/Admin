package com.catchmind.admin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DecComApiResponse {
    private Long decIdx;
    private Long revIdx;
    private Long comIdx;
    private String decNick;
    private String prNick;
    private String comContent;
    private String decContent;
    private String resaBisName;
    private LocalDateTime regDate;

}
