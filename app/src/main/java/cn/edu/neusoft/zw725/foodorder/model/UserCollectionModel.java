package cn.edu.neusoft.zw725.foodorder.model;

import java.util.List;

import cn.edu.neusoft.zw725.foodorder.bean.UserCollectionBean;
import cn.edu.neusoft.zw725.foodorder.iface.UserCollectionIface;
import cn.edu.neusoft.zw725.foodorder.listener.ListListener;
import cn.edu.neusoft.zw725.foodorder.service.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by china on 2017/12/13.
 */

public class UserCollectionModel extends BaseModel implements UserCollectionIface<UserCollectionBean> {
    private Service service;
    private Retrofit retrofit;

    public UserCollectionModel(){
        retrofit = getRetrofit();
        service = getService();
    }

    @Override
    public void getUserCollection(String user_id, String flag,final ListListener<UserCollectionBean> listListener) {
        Call<List<UserCollectionBean>> call = service.getUserCollectionBean(user_id,flag);
        callenqueueList(call,listListener);
    }
}
