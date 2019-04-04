package com.youzan.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * Created by baimugudu on 2019/3/27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResquest {

    String username;

    public boolean validate(){
        return !StringUtils.isEmpty(username);
    }

}
