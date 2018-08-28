package cn.edu.neusoft.zw725.foodorder.iface;

import cn.edu.neusoft.zw725.foodorder.listener.ListListener;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;

/**
 * Created by china on 2017/11/8.
 */

public interface FoodByShopIface<T> {
    void getFoodByShopBean(String shop_id, ListListener<T> listListener);
}
