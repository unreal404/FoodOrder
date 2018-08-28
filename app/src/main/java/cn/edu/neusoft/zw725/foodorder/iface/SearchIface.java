package cn.edu.neusoft.zw725.foodorder.iface;

import cn.edu.neusoft.zw725.foodorder.listener.ListListener;

/**
 * Created by china on 2017/12/18.
 */

public interface SearchIface<T> {
    void getAllFood(String search, ListListener<T> listListener);
}
