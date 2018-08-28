package cn.edu.neusoft.zw725.foodorder.model;

import cn.edu.neusoft.zw725.foodorder.bean.CollectBean;
import cn.edu.neusoft.zw725.foodorder.bean.RegBean;
import cn.edu.neusoft.zw725.foodorder.iface.CollectShopIface;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by china on 2017/12/11.
 */

public class CollectShopModel extends BaseModel implements CollectShopIface {
    private Service service;
    private Retrofit retrofit;

    public CollectShopModel(){
        retrofit = getRetrofit();
        service = getService();
    }

    @Override
    public void judge(String user_id, String shop_food_id, String flag, TListener<CollectBean> tListener) {
        Call<CollectBean> call = service.isCollected(user_id,shop_food_id,flag);
        callenqueue(call,tListener);
    }

    @Override
    public void collect(String user_id, String shop_id, TListener<RegBean> tListener) {
        Call<RegBean> call = service.getCollectShop(user_id,shop_id);
        callenqueue(call,tListener);
    }
}
