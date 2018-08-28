package cn.edu.neusoft.zw725.foodorder.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import cn.edu.neusoft.zw725.foodorder.R;
import cn.edu.neusoft.zw725.foodorder.activity.FoodDetailedActivity;
import cn.edu.neusoft.zw725.foodorder.bean.FoodByShopBean;
import cn.edu.neusoft.zw725.foodorder.viewHolder.FoodViewHolder;

/**
 * Created by china on 2017/12/4.
 */

public class FoodAdapter extends BaseAdapter<FoodByShopBean>{

    public FoodAdapter(Context context, List<FoodByShopBean> items, int layoutResource) {
        super(context, items, layoutResource);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(layoutResource,parent,false);
        FoodViewHolder foodViewHolder = new FoodViewHolder(itemView);
        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final FoodViewHolder foodViewHolder = (FoodViewHolder)holder;
        foodViewHolder.tv_foodname.setText(items.get(position).getFoodname());
        foodViewHolder.tv_food_intro.setText(items.get(position).getIntro());
        foodViewHolder.price.setText("￥"+items.get(position).getPrice());
        /*foodViewHolder.food_pic.setImageBitmap(BitmapFactory.decodeResource(context
                .getResources(),R.drawable.ic_shop_normal));*/
        Picasso.with(context).load(items.get(position).getPic()).into(foodViewHolder.food_pic);

        foodViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = foodViewHolder.getLayoutPosition();
                Intent intent = new Intent(context, FoodDetailedActivity.class);
                intent.putExtra("foodname",items.get(position).getFoodname());
                intent.putExtra("foodintro",items.get(position).getIntro());
                intent.putExtra("price",items.get(position).getPrice());
                intent.putExtra("foodpic",items.get(position).getPic());
                intent.putExtra("food_id",items.get(position).getFood_id());
                Log.i("TEST","onClick");
                context.startActivity(intent);
            }
        });
    }
}
