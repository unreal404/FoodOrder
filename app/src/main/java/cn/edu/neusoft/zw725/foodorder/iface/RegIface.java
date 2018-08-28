package cn.edu.neusoft.zw725.foodorder.iface;

import cn.edu.neusoft.zw725.foodorder.listener.TListener;

/**
 * Created by china on 2017/11/1.
 */

public interface RegIface<T> {
    void getRegBean(String username, String userpass, String mobilenum, String address, String comment, TListener<T> tListener);
}
