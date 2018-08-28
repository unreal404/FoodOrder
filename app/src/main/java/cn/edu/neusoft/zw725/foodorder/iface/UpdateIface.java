package cn.edu.neusoft.zw725.foodorder.iface;

import cn.edu.neusoft.zw725.foodorder.listener.TListener;

/**
 * Created by china on 2017/12/18.
 */

public interface UpdateIface<T> {
    void getUpdate(String user_id, String username, String userpass, String mobilenum, String address, TListener<T> tListener);
}
