package com.catchmind.admin.model.network.request;

import com.catchmind.admin.model.entity.ResAdmin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BisInfoApiRequest {
    private String resaBisName;
}
