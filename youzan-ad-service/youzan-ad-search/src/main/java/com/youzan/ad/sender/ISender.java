package com.youzan.ad.sender;


import com.youzan.ad.mysql.dto.MySqlRowData;

/**
 * Created by Qinyi.
 */
public interface ISender {

    void sender(MySqlRowData rowData);
}
