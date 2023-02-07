package com.catchmind.admin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacilityApiResponse {
    private Long facIdx;
    private String resaBisName;
    private Long bisIdx;
    private boolean facParking;
    private boolean facValet;
    private boolean facCorkage;
    private boolean facNokid;
    private boolean facAnimal;
    private boolean facHandi;}
