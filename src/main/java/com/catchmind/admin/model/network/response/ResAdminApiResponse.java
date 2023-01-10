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
public class ResAdminApiResponse {
    private String resaBisName;
    private String resaUserid;
    private String resaUserpw;
    private String resaName;
    private String resaHp;
    private String resaRegion;
    private LocalDateTime regDate;
}