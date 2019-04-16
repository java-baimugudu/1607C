package com.youzan.ad.mysql.dto;

import com.github.shyiko.mysql.binlog.event.EventType;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by baimugudu on 2019/4/11
 */

@Data
public class BinLogRowData {
    private TableTemplate table;
    private EventType eventType;
    private List<Map<String,String>> before;
    private List<Map<String,String>> after;


}
