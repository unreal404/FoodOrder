package cn.edu.neusoft.zw725.foodorder.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.edu.neusoft.zw725.foodorder.R;

/**
 * Created by china on 2017/11/29.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter{
    Context context;
    List<T> items;
    int layoutResource;

    public BaseAdapter(Context context, List<T> items, int layoutResource) {
        this.context = context;
        this.items = items;
        this.layoutResource = layoutResource;
    }





    @Override
    public int getItemCount() {
        if(items == null){
            return 0;
        }else{
            return items.size();
        }
    }
}
