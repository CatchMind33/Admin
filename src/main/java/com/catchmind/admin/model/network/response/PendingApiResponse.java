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
public class PendingApiResponse {
    private Long penIdx;
    private String penBisName;
    private String penHp;
    private String penName;
    private String penRegion;
    private String penBook;
    private String penFoodtype;
    private LocalDateTime regDate;
}
