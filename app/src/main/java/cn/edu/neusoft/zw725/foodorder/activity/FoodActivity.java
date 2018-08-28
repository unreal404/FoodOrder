package cn.edu.neusoft.zw725.foodorder.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import cn.edu.neusoft.zw725.foodorder.R;
import cn.edu.neusoft.zw725.foodorder.adapter.FoodAdapter;
import cn.edu.neusoft.zw725.foodorder.bean.CollectBean;
import cn.edu.neusoft.zw725.foodorder.bean.FoodByShopBean;
import cn.edu.neusoft.zw725.foodorder.bean.RegBean;
import cn.edu.neusoft.zw725.foodorder.listener.ListListener;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.model.CollectShopModel;
import cn.edu.neusoft.zw725.foodorder.model.FoodByShopModel;

/**
 * Created by china on 2017/11/29.
 */

public class FoodActivity extends BaseActivity {
    private ImageButton img_return;
    private TextView tv_shopname;
    private ImageButton img_collect;
    private boolean flag;

    final List<FoodByShopBean> items = new ArrayList<FoodByShopBean>();
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ListListener<FoodByShopBean> listListener = new ListListener<FoodByShopBean>() {
        @Override
        public void onResponse(List<FoodByShopBean> list) {
            FoodAdapter foodAdapter = new FoodAdapter(FoodActivity.this,list,R.layout.food_card);
            recyclerView.setAdapter(foodAdapter);
        }

        @Override
        public void onFail(String msg) {
            showToast("404");
        }
    };
    TListener<CollectBean> judgListener = new TListener<CollectBean>() {
        @Override
        public void onResponse(CollectBean collectBean) {
            if(collectBean.getCollected().equals("0")){
                img_collect.setImageResource(R.drawable.ic_collect_normal);
                flag = false;
            }
            else {
                img_collect.setImageResource(R.drawable.ic_collect_pressed);
                flag = true;
            }
        }

        @Override
        public void onFail(String msg) {

        }
    };
    TListener<RegBean> collectListener = new TListener<RegBean>() {
        @Override
        public void onResponse(RegBean regBean) {
            if(regBean.getSuccess().equals("0")){
                showToast("收藏失败");
            }
            else{
                if(flag == false){
                    showToast("收藏成功");
                    img_collect.setImageResource(R.drawable.ic_collect_pressed);
                    flag = true;
                }else {
                    showToast("取消收藏");
                    img_collect.setImageResource(R.drawable.ic_collect_normal);
                    flag = false;
                }
            }
        }

        @Override
        public void onFail(String msg) {

        }
    };

    @Override
    void initView() {
        setLayout_file(R.layout.activity_food);

        img_return = (ImageButton)findViewById(R.id.img_return);
        tv_shopname = (TextView)findViewById(R.id.tv_shopname);
        img_collect = (ImageButton)findViewById(R.id.img_collect);


        recyclerView = (RecyclerView)findViewById(R.id.food_rec);
        layoutManager = new LinearLayoutManager(FoodActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(FoodActivity.this,LinearLayoutManager.VERTICAL));


    }

    @Override
    void initEvent() {
        img_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        img_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String shop_id = intent.getStringExtra("id");
                String user_id = getUser_id();

                CollectShopModel collectShopModel = new CollectShopModel();
                collectShopModel.collect(user_id,shop_id,collectListener);

            }
        });
    }

    @Override
    void initData() {
        Intent intent = getIntent();
        String shopname = intent.getStringExtra("shopname");
        tv_shopname.setText(shopname);
        String shop_id = intent.getStringExtra("id");

        SharedPreferences shop_sp = getSharedPreferences("shop_sp",MODE_PRIVATE);
        SharedPreferences.Editor editor = shop_sp.edit();
        editor.putString("shop_id",shop_id);
        editor.putString("shop_name",shopname);
        editor.commit();

        FoodByShopModel foodByShopModel = new FoodByShopModel();
        foodByShopModel.getFoodByShopBean(shop_id,listListener);

        String user_id = getUser_id();

        CollectShopModel collectShopModel = new CollectShopModel();
        collectShopModel.judge(user_id,shop_id,"0",judgListener);
    }

}
