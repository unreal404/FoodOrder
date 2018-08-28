package cn.edu.neusoft.zw725.foodorder.model;

import java.util.List;

import cn.edu.neusoft.zw725.foodorder.bean.UserDateBean;
import cn.edu.neusoft.zw725.foodorder.iface.UserDateIface;
import cn.edu.neusoft.zw725.foodorder.listener.ListListener;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by china on 2017/12/18.
 */

public class UserDateModel extends BaseModel implements UserDateIface<UserDateBean> {
    private Service service;
    private Retrofit retrofit;

    public UserDateModel(){
        retrofit = getRetrofit();
        service = getService();
    }

    @Override
    public void getUserDate(String user_id, TListener<UserDateBean> tListener) {
        Call<UserDateBean> call = service.getUserDate(user_id);
        callenqueue(call,tListener);
    }
}
