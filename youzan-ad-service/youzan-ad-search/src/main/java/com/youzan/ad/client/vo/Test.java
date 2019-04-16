package com.youzan.ad.client.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author Fei
 * @data 2019-04-09 下午 08:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    private Long userId;
    private List<Long> ids;

    public boolean validate(){
        return userId!=null&&!CollectionUtils.isEmpty(ids);
    }

}
