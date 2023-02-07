package com.catchmind.admin.model.network.response;

import com.catchmind.admin.model.entity.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewApiResponse {
    private Long revIdx;
    private String revNick;
    private int revLike;
    private String revContent;
    private double revScore;
    private Long revComm;
    private String resaBisName;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private Profile prIdx;

}
