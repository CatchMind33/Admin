package com.catchmind.admin.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResAdminApiRequest {
    private String resaBisName;
    private String resaUserid;
    private String resaUserpw;
    private String resaName;
    private String resaHp;
    private String resaRegion;
}