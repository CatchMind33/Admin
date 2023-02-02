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
public class DecReviewApiResponse {
    private Long derIdx;
    private Long revIdx;
    private String derNick;
    private String prNick;
    private String derContent;
    private String revContent;
    private String resaBisName;
    private LocalDateTime regDate;
}
