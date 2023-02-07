package com.catchmind.admin.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewApiRequest {
    private Long revIdx;
    private Long prIdx;
    private String revNick;
    private int revLike;
    private String revContent;
    private double revScore;
    private Long revComm;
    private String resaBisName;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}
