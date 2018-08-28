package cn.edu.neusoft.zw725.foodorder.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.neusoft.zw725.foodorder.R;
import cn.edu.neusoft.zw725.foodorder.adapter.CollectShopAdapter;

/**
 * Created by china on 2017/12/13.
 */

public class CollectShopViewHolder extends RecyclerView.ViewHolder{
    public ImageView collectshop_pic;
    public TextView tv_collectshopname;
    public TextView tv_collectaddress;

    public CollectShopViewHolder(View itemView){
        super(itemView);

        collectshop_pic = (ImageView)itemView.findViewById(R.id.collectshop_pic);
        tv_collectshopname = (TextView)itemView.findViewById(R.id.tv_collectshopname);
        tv_collectaddress= (TextView)itemView.findViewById(R.id.tv_collectaddress);
    }
}
