package com.youzan.ad.mysql.listener;


import com.youzan.ad.mysql.dto.BinLogRowData;

/**
 * Created by Qinyi.
 */
public interface Ilistener {

    void register();

    void onEvent(BinLogRowData eventData);
}
