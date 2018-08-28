package cn.edu.neusoft.zw725.foodorder.model;

import java.util.List;

import cn.edu.neusoft.zw725.foodorder.bean.AllShopBean;
import cn.edu.neusoft.zw725.foodorder.iface.AllShopIface;
import cn.edu.neusoft.zw725.foodorder.listener.ListListener;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by china on 2017/11/8.
 */

public class AllShopModel extends BaseModel implements AllShopIface<AllShopBean> {
    private Service service;
    private Retrofit retrofit;

    public AllShopModel(){
        retrofit = getRetrofit();
        service = getService();
    }

    @Override
    public void getAllShopBean(final ListListener<AllShopBean> listListener) {
        Call<List<AllShopBean>> call = service.getAllSopBean();
        callenqueueList(call,listListener);
    }
}
