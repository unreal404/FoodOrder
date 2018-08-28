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
import cn.edu.neusoft.zw725.foodorder.bean.UserCollectionBean;
import cn.edu.neusoft.zw725.foodorder.viewHolder.CollectFoodViewHolder;

/**
 * Created by china on 2017/12/16.
 */

public class CollectFoodAdapter extends BaseAdapter<UserCollectionBean> {
    public CollectFoodAdapter(Context context, List<UserCollectionBean> items, int layoutResource) {
        super(context, items, layoutResource);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(layoutResource,parent,false);
        CollectFoodViewHolder collectFoodViewHolder = new CollectFoodViewHolder(itemView);
        return collectFoodViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final CollectFoodViewHolder collectFoodViewHolder = (CollectFoodViewHolder)holder;
        collectFoodViewHolder.tv_collectfoodname.setText(items.get(position).getFoodname());
        collectFoodViewHolder.tv_collectprice.setText("￥"+items.get(position).getPrice());
        collectFoodViewHolder.collectfood_pic.setImageBitmap(BitmapFactory.decodeResource(context
                .getResources(), R.drawable.ic_shop_normal));
        Picasso.with(context).load(items.get(position).getPic()).into(collectFoodViewHolder.collectfood_pic);

        collectFoodViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = collectFoodViewHolder.getLayoutPosition();
                Intent intent = new Intent(context, FoodDetailedActivity.class);
                intent.putExtra("foodname",items.get(position).getFoodname());
                intent.putExtra("price",items.get(position).getPrice());
                intent.putExtra("foodpic",items.get(position).getPic());
                intent.putExtra("food_id",items.get(position).getFood_id());
                Log.i("TEST","onClick");
                context.startActivity(intent);
            }
        });
    }
}
