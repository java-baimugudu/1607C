package com.youzan.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by baimugudu on 2019/3/29
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitKeyWordRequest {


    private List<UnitKeyWords> unitKeyWord;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UnitKeyWords{
        private Long unitId;
        private String keyword;
    }


}
