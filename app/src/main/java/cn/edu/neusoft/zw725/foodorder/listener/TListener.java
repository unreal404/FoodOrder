package cn.edu.neusoft.zw725.foodorder.listener;

/**
 * Created by china on 2017/11/6.
 */

public interface TListener<T> {
    void onResponse(T t);
    void onFail(String msg);
}
