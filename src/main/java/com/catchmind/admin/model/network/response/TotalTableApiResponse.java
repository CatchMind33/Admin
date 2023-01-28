package com.catchmind.admin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TotalTableApiResponse {
    private Long totTableId;
    private String resaBisName;
    private String totCapacity;
    private String totTable;
}
