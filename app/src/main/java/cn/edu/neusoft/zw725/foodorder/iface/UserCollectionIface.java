package cn.edu.neusoft.zw725.foodorder.iface;

import cn.edu.neusoft.zw725.foodorder.listener.ListListener;

/**
 * Created by china on 2017/12/13.
 */

public interface UserCollectionIface<T> {
    void getUserCollection(String user_id, String flag, ListListener<T> listListener);
}
