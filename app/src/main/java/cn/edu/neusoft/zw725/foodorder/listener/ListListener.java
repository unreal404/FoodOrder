package cn.edu.neusoft.zw725.foodorder.listener;

import java.util.List;

/**
 * Created by china on 2017/11/27.
 */

public interface ListListener<T> {
    void onResponse(List<T> list);
    void onFail(String msg);
}
