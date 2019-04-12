package com.youzan.ad.mysql.dto;

import com.youzan.ad.mysql.constant.OpType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by baimugudu on 2019/4/11
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableTemplate {

    private String tableName;
    private String level;


   // mysql binlog字段索引（下标）-》字段名
    private Map<Integer,String> posMap = new HashMap<>();

    //操作类型-》字段
    private Map<OpType, List<String>> opTypeFieldMap = new HashMap<>();


}
