package com.catchmind.admin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImpApiResponse {

    private Long impIdx;
    private String impTitle;
    private String impContent;
    private String impNick;
    private String impAnswer;
    private String impStatus;


}

