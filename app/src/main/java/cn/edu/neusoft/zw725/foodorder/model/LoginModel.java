package cn.edu.neusoft.zw725.foodorder.model;


import cn.edu.neusoft.zw725.foodorder.bean.LoginBean;
import cn.edu.neusoft.zw725.foodorder.iface.LoginIface;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;


/**
 * Created by china on 2017/11/1.
 */

public class LoginModel extends BaseModel implements LoginIface<LoginBean> {
    private Service service;
    private Retrofit retrofit;

    public LoginModel(){
        retrofit = getRetrofit();
        service = getService();
    }

    @Override
    public void getLoginBean(String username, String userpass, final TListener<LoginBean> tListener) {
        Call<LoginBean> call = service.getLoginBean(username,userpass);
        callenqueue(call,tListener);
    }
}
