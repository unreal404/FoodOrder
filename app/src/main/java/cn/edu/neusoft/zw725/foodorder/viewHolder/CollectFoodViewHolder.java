package cn.edu.neusoft.zw725.foodorder.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.neusoft.zw725.foodorder.R;

/**
 * Created by china on 2017/12/16.
 */

public class CollectFoodViewHolder extends RecyclerView.ViewHolder {
    public ImageView collectfood_pic;
    public TextView tv_collectfoodname;
    public TextView tv_collectprice;

    public CollectFoodViewHolder(View itemView){
        super(itemView);

        collectfood_pic = (ImageView)itemView.findViewById(R.id.collectfood_pic);
        tv_collectfoodname = (TextView)itemView.findViewById(R.id.tv_collectfoodname);
        tv_collectprice = (TextView)itemView.findViewById(R.id.tv_collectprice);
    }
}
