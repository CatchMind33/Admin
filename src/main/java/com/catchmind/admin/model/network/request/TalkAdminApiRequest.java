package com.catchmind.admin.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TalkAdminApiRequest {
    private String taaNick;
    private String taaResaBisName;
    private String taaContent;

}
