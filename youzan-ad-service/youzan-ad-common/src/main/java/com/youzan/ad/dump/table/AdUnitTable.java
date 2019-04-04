package com.youzan.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by baimugudu on 2019/4/3
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitTable {
    private Long unitId;

    private Integer unitStatus;

    private Integer positionType;

    private Long planId;
}
