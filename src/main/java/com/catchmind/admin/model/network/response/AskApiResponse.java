package com.catchmind.admin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AskApiResponse {
    private Long askIdx;
    private String askTitle;
    private String askContent;
    private Long prIdx;
    private String askAnswer;
    private boolean askStatus;
}

