package cn.edu.neusoft.zw725.foodorder.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.neusoft.zw725.foodorder.R;
/**
 * Created by china on 2017/12/4.
 */

public class FoodViewHolder extends RecyclerView.ViewHolder{
    public ImageView food_pic;
    public TextView tv_foodname;
    public TextView tv_food_intro;
    public TextView price;

    public FoodViewHolder(View itemView){
        super(itemView);

        food_pic = (ImageView)itemView.findViewById(R.id.food_pic);
        tv_foodname = (TextView)itemView.findViewById(R.id.tv_foodname);
        tv_food_intro = (TextView)itemView.findViewById(R.id.tv_food_intro);
        price = (TextView)itemView.findViewById(R.id.price);
    }
}
