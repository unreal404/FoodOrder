package cn.edu.neusoft.zw725.foodorder.model;

import cn.edu.neusoft.zw725.foodorder.bean.RegBean;
import cn.edu.neusoft.zw725.foodorder.iface.UpdateIface;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by china on 2017/12/18.
 */

public class UpdateModel extends BaseModel implements UpdateIface<RegBean> {
    private Service service;
    private Retrofit retrofit;

    public UpdateModel(){
        retrofit = getRetrofit();
        service = getService();
    }

    @Override
    public void getUpdate(String user_id, String username, String userpass, String mobilenum, String address, TListener<RegBean> tListener) {
        Call<RegBean> call = service.getUpdate(user_id, username, userpass, mobilenum, address);
        callenqueue(call,tListener);
    }
}
