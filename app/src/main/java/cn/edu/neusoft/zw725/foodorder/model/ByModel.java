package cn.edu.neusoft.zw725.foodorder.model;

import cn.edu.neusoft.zw725.foodorder.bean.ByBean;
import cn.edu.neusoft.zw725.foodorder.iface.ByIface;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by china on 2017/12/6.
 */

public class ByModel extends BaseModel implements ByIface<ByBean> {
    private Service service;
    private Retrofit retrofit;

    public ByModel(){
        retrofit = getRetrofit();
        service = getService();
    }

    @Override
    public void getByBean(String user_id, String food_id, String num, String sum, String suggesttime, TListener<ByBean> tListener) {
        Call<ByBean> call = service.getByBean(user_id,food_id,num,sum,suggesttime);
        callenqueue(call,tListener);
    }
}
