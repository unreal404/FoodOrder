package cn.edu.neusoft.zw725.foodorder.iface;

import cn.edu.neusoft.zw725.foodorder.listener.TListener;

/**
 * Created by china on 2017/12/6.
 */

public interface ByIface<T> {
    void getByBean(String user_id, String food_id, String num, String sum, String suggesttime, TListener<T> tListener);
}
