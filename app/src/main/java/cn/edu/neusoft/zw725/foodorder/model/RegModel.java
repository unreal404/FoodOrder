package cn.edu.neusoft.zw725.foodorder.model;


import cn.edu.neusoft.zw725.foodorder.bean.RegBean;

import cn.edu.neusoft.zw725.foodorder.iface.RegIface;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by china on 2017/11/1.
 */

public class RegModel extends BaseModel implements RegIface<RegBean> {
    private Service service;
    private Retrofit retrofit;

    public RegModel(){
        retrofit = getRetrofit();
        service = getService();
    }

    @Override
    public void getRegBean(String username, String userpass, String mobilenum, String address, String comment, final TListener<RegBean> tListener) {
        Call<RegBean> call = service.getRegBean(username,userpass,mobilenum,address,comment);
        callenqueue(call,tListener);
    }
}
