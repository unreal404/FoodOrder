package cn.edu.neusoft.zw725.foodorder.iface;

import cn.edu.neusoft.zw725.foodorder.listener.ListListener;

/**
 * Created by china on 2017/11/8.
 */

public interface AllShopIface<T> {
    void getAllShopBean(ListListener<T> listListener);
}
