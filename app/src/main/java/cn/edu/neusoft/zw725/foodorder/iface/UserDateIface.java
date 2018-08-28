package cn.edu.neusoft.zw725.foodorder.iface;

import cn.edu.neusoft.zw725.foodorder.listener.TListener;

/**
 * Created by china on 2017/12/18.
 */

public interface UserDateIface<T> {
    void getUserDate(String user_id, TListener<T> tListener);
}
