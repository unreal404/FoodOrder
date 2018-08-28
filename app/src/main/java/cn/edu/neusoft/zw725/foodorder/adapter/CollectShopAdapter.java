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
import cn.edu.neusoft.zw725.foodorder.activity.FoodActivity;
import cn.edu.neusoft.zw725.foodorder.bean.UserCollectionBean;
import cn.edu.neusoft.zw725.foodorder.viewHolder.CollectShopViewHolder;
import cn.edu.neusoft.zw725.foodorder.viewHolder.ShopViewHolder;

/**
 * Created by china on 2017/12/13.
 */

public class CollectShopAdapter extends BaseAdapter<UserCollectionBean> {
    public CollectShopAdapter(Context context, List<UserCollectionBean> items, int layoutResource) {
        super(context, items, layoutResource);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(layoutResource,parent,false);
        CollectShopViewHolder collectShopViewHolder = new CollectShopViewHolder(itemView);
        return collectShopViewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final CollectShopViewHolder collectShopViewHolder = (CollectShopViewHolder)holder;
        collectShopViewHolder.tv_collectshopname.setText(items.get(position).getShopname());
        collectShopViewHolder.tv_collectaddress.setText(items.get(position).getAddress());
        collectShopViewHolder.collectshop_pic.setImageBitmap(BitmapFactory.decodeResource(context
                .getResources(), R.drawable.ic_shop_normal));
        Picasso.with(context).load(items.get(position).getPic()).into(collectShopViewHolder.collectshop_pic);

        collectShopViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = collectShopViewHolder.getLayoutPosition();
                Intent intent = new Intent(context,FoodActivity.class);
                intent.putExtra("id",items.get(position).getShop_id());
                intent.putExtra("shopname",items.get(position).getShopname());
                Log.i("TEST","onClick");
                context.startActivity(intent);
            }
        });
    }
}
