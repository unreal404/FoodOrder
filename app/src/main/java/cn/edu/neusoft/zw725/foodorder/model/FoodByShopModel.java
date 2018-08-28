package cn.edu.neusoft.zw725.foodorder.model;

import java.util.List;

import cn.edu.neusoft.zw725.foodorder.bean.FoodByShopBean;
import cn.edu.neusoft.zw725.foodorder.iface.FoodByShopIface;
import cn.edu.neusoft.zw725.foodorder.listener.ListListener;
import cn.edu.neusoft.zw725.foodorder.service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by china on 2017/11/8.
 */

public class FoodByShopModel extends BaseModel implements FoodByShopIface<FoodByShopBean> {
    Service service;
    Retrofit retrofit;

    public FoodByShopModel(){
        retrofit = getRetrofit();
        service = getService();
    }

    @Override
    public void getFoodByShopBean(String shop_id, final ListListener<FoodByShopBean> listListener) {
        Call<List<FoodByShopBean>> call = service.getFoodByShopBean(shop_id);
        callenqueueList(call,listListener);
    }
}
