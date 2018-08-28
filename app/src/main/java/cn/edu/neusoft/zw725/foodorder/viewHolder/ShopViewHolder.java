package cn.edu.neusoft.zw725.foodorder.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.neusoft.zw725.foodorder.R;

/**
 * Created by china on 2017/11/29.
 */

public class ShopViewHolder extends RecyclerView.ViewHolder{
    public ImageView shop_pic;
    public TextView tv_shopname;
    public TextView tv_intro;
    public TextView tv_address;

    public ShopViewHolder(View itemView){
        super(itemView);

        shop_pic = (ImageView)itemView.findViewById(R.id.shop_pic);
        tv_shopname = (TextView)itemView.findViewById(R.id.tv_shopname);
        tv_intro = (TextView)itemView.findViewById(R.id.tv_intro);
        tv_address = (TextView)itemView.findViewById(R.id.tv_address);
    }
}
