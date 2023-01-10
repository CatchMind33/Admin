package com.catchmind.admin.model.network.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileResponse {
    private Long prIdx;
    private String prNick;
    private String prName;
    private String prIntro;
    private String prRegion;
    private String prHp;
    private String prUserpw;
    private String prGender;
    private String prBirth;
    private String prMemo;
    private int prReview;
    private int prNoshow;
    private boolean prBlock;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}
