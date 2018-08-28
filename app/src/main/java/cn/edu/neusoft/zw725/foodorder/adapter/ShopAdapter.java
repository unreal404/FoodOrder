package cn.edu.neusoft.zw725.foodorder.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;


import cn.edu.neusoft.zw725.foodorder.R;
import cn.edu.neusoft.zw725.foodorder.activity.BaseActivity;
import cn.edu.neusoft.zw725.foodorder.activity.FoodActivity;
import cn.edu.neusoft.zw725.foodorder.bean.AllShopBean;
import cn.edu.neusoft.zw725.foodorder.viewHolder.ShopViewHolder;

/**
 * Created by china on 2017/11/27.
 */

public class ShopAdapter extends BaseAdapter<AllShopBean>{

    public ShopAdapter(Context context, List<AllShopBean> items, int layoutResource) {
        super(context, items, layoutResource);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(layoutResource,parent,false);
        ShopViewHolder shopViewHolder = new ShopViewHolder(itemView);
        return shopViewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ShopViewHolder shopViewHolder = (ShopViewHolder)holder;
        shopViewHolder.tv_shopname.setText(items.get(position).getShopname());
        shopViewHolder.tv_intro.setText(items.get(position).getIntro());
        shopViewHolder.tv_address.setText(items.get(position).getAddress());
        shopViewHolder.shop_pic.setImageBitmap(BitmapFactory.decodeResource(context
                .getResources(), R.drawable.ic_shop_normal));
        Picasso.with(context).load(items.get(position).getPic()).into(shopViewHolder.shop_pic);

        shopViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = shopViewHolder.getLayoutPosition();
                Intent intent = new Intent(context,FoodActivity.class);
                intent.putExtra("id",items.get(position).getShop_id());
                intent.putExtra("shopname",items.get(position).getShopname());
                Log.i("TEST","onClick");
                context.startActivity(intent);
            }
        });
    }



}

