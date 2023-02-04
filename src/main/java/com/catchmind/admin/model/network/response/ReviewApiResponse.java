package com.catchmind.admin.model.network.response;

import com.catchmind.admin.model.entity.Profile;
import com.catchmind.admin.model.entity.ResAdmin;
import com.catchmind.admin.model.entity.Reserve;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

}
