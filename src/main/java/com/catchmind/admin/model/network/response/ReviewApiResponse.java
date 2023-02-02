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
    private Long revLike;
    private String revContent;
    private Double revScore;
    private String orgNm;
    private String savedNm;
    private String savedPath;
    private Long res_idx;
    private String prNick;
    private Long revIdx;
    private String resaBisName;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

}
