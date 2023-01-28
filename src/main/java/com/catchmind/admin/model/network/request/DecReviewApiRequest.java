package com.catchmind.admin.model.network.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DecReviewApiRequest {
    private Long derIdx;
    private Long revIdx;
    private String derNick;

}
