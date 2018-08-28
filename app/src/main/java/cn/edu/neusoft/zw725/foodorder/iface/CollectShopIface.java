package cn.edu.neusoft.zw725.foodorder.iface;

import cn.edu.neusoft.zw725.foodorder.bean.CollectBean;
import cn.edu.neusoft.zw725.foodorder.bean.RegBean;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;

/**
 * Created by china on 2017/12/11.
 */

public interface CollectShopIface {
    void judge(String user_id, String shop_food_id, String flag, TListener<CollectBean> tListener);
    void collect(String user_id, String shop_id, TListener<RegBean> tListener);
}
