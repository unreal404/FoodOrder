package cn.edu.neusoft.zw725.foodorder.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cn.edu.neusoft.zw725.foodorder.R;
import cn.edu.neusoft.zw725.foodorder.bean.CollectBean;
import cn.edu.neusoft.zw725.foodorder.bean.RegBean;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.model.CollectFoodModel;

/**
 * Created by china on 2017/12/4.
 */

public class FoodDetailedActivity extends BaseActivity{
    private ImageView img_food;
    private ImageButton img_d_return;
    private ImageButton img_d_collect;
    private TextView tv_d_foodname;
    private TextView tv_fcon_name;
    private TextView tv_fcon_intro;
    private TextView tv_fcon_price;
    private Button btn_by;
    private boolean flag;
    private TListener<CollectBean> judgListener = new TListener<CollectBean>() {
        @Override
        public void onResponse(CollectBean collectBean) {
            if(collectBean.getCollected().equals("0")){
                img_d_collect.setImageResource(R.drawable.ic_collect_normal);
                flag = false;
            }
            else {
                img_d_collect.setImageResource(R.drawable.ic_collect_pressed);
                flag = true;
            }
        }

        @Override
        public void onFail(String msg) {

        }
    };
    private TListener<RegBean> collectListener = new TListener<RegBean>() {
        @Override
        public void onResponse(RegBean regBean) {
            if(regBean.getSuccess().equals("0")){
                showToast("收藏失败");
            }
            else{
                if(flag == false){
                    showToast("收藏成功");
                    img_d_collect.setImageResource(R.drawable.ic_collect_pressed);
                    flag = true;
                }else {
                    showToast("取消收藏");
                    img_d_collect.setImageResource(R.drawable.ic_collect_normal);
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
        setLayout_file(R.layout.fragment_food_detailed);

        img_food = (ImageView)findViewById(R.id.img_food);
        tv_fcon_name = (TextView)findViewById(R.id.tv_fcon_name);
        tv_fcon_intro = (TextView)findViewById(R.id.tv_fcon_intro);
        tv_fcon_price = (TextView)findViewById(R.id.tv_fcon_price);
        img_d_return = (ImageButton)findViewById(R.id.img_d_return);
        img_d_collect = (ImageButton)findViewById(R.id.img_d_collect);
        tv_d_foodname = (TextView)findViewById(R.id.tv_d_foodname);
        btn_by = (Button)findViewById(R.id.btn_by);

        Intent intent = getIntent();
        String img = intent.getStringExtra("foodpic");
        String name = intent.getStringExtra("foodname");
        String intro = intent.getStringExtra("foodintro");
        String price = intent.getStringExtra("price");
        String food_id = intent.getStringExtra("food_id");

        SharedPreferences shop_sp;
        shop_sp = getSharedPreferences("shop_sp", Context.MODE_PRIVATE);

        Picasso.with(FoodDetailedActivity.this).load(img).into(img_food);
        tv_fcon_name.setText(name);
        tv_fcon_intro.setText(intro);
        tv_fcon_price.setText("￥"+price);
        tv_d_foodname.setText(shop_sp.getString("shop_name",""));

        SharedPreferences.Editor editor = shop_sp.edit();
        editor.putString("food_id",food_id);
        editor.putString("food_name",name);
        editor.putString("price",price);
        editor.commit();

    }

    @Override
    void initEvent() {
        img_d_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        img_d_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shop_sp = getSharedPreferences("shop_sp",MODE_PRIVATE);
                String food_id = shop_sp.getString("food_id","");

                CollectFoodModel collectFoodModel = new CollectFoodModel();
                collectFoodModel.collect(getUser_id(),food_id,collectListener);

            }
        });
        btn_by.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodDetailedActivity.this,FoodByActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    void initData() {
        Intent intent = getIntent();
        String food_id = intent.getStringExtra("food_id");

        CollectFoodModel collectFoodModel = new CollectFoodModel();
        collectFoodModel.judge(getUser_id(),food_id,"1",judgListener);
    }
}
