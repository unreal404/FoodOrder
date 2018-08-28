package cn.edu.neusoft.zw725.foodorder.model;

import java.util.List;

import cn.edu.neusoft.zw725.foodorder.Service_s;
import cn.edu.neusoft.zw725.foodorder.listener.ListListener;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by china on 2017/11/8.
 */

public class BaseModel {
    private Service service;
    private Retrofit retrofit;

    public Retrofit getRetrofit(){
        retrofit = new Retrofit.Builder().baseUrl(Service_s.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    public Service getService(){
        service = retrofit.create(Service.class);
        return service;
    }
    public <T>void callenqueue(Call<T> call, final TListener<T> tListener){
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    tListener.onResponse(response.body());
                }
                else{
                    tListener.onFail("error");
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                tListener.onFail("error");
            }
        });
    }
    public <T> void callenqueueList(Call<List<T>> call, final ListListener<T> listListener){
        call.enqueue(new Callback<List<T>>() {
            @Override
            public void onResponse(Call<List<T>> call, Response<List<T>> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    listListener.onResponse(response.body());
                }
                else {
                    listListener.onFail("error");
                }
            }

            @Override
            public void onFailure(Call<List<T>> call, Throwable t) {
                listListener.onFail("error");
            }
        });
    }
}
