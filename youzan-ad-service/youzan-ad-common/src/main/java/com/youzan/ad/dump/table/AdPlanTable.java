package com.youzan.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by baimugudu on 2019/4/3
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanTable {

    private Long planId;

    private Long userId;

    private Integer planStatus;

    private Date startDate;

    private Date endDate;
}
