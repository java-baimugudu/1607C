package com.youzan.ad.index.district;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by baimugudu on 2019/4/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitDistrictObject {

    private Long unitId;
    private String province;
    private String city;

}
