package cn.edu.neusoft.zw725.foodorder.model;

import java.util.List;

import cn.edu.neusoft.zw725.foodorder.bean.FoodByShopBean;
import cn.edu.neusoft.zw725.foodorder.iface.SearchIface;
import cn.edu.neusoft.zw725.foodorder.listener.ListListener;
import cn.edu.neusoft.zw725.foodorder.service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by china on 2017/12/18.
 */

public class AllFoodModel extends BaseModel implements SearchIface<FoodByShopBean> {
    private Service service;
    private Retrofit retrofit;

    public AllFoodModel(){
        retrofit = getRetrofit();
        service = getService();
    }

    @Override
    public void getAllFood(String search, ListListener<FoodByShopBean> listListener) {
        Call<List<FoodByShopBean>> call = service.getAllFood(search);
        callenqueueList(call,listListener);
    }
}
