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
public class AdUnitKeywordTable {
    private Long unitId;
    private String keyword;
}
