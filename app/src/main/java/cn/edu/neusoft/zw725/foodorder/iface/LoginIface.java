package cn.edu.neusoft.zw725.foodorder.iface;

import cn.edu.neusoft.zw725.foodorder.listener.TListener;

/**
 * Created by china on 2017/11/1.
 */

public interface LoginIface<T> {
    void getLoginBean(String username, String userpass, TListener<T> tListener);
}
