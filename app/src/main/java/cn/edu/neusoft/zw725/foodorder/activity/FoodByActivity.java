package cn.edu.neusoft.zw725.foodorder.activity;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.edu.neusoft.zw725.foodorder.R;
import cn.edu.neusoft.zw725.foodorder.bean.ByBean;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.model.ByModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodByActivity extends BaseActivity {
    private TextView tv_userid;
    private EditText ed_toaddress;
    private TextView tv_byshopname;
    private TextView tv_byfoodname;
    private TextView tv_byfoodprice;
    private EditText ed_num;
    private TextView tvt_sum;
    private EditText ed_time;
    private Button btn_byreturn;
    private Button btn_buy;
    private TListener<ByBean> tListener = new TListener<ByBean>() {
        @Override
        public void onResponse(ByBean byBean) {
            if(byBean.getSuccess().equals("0")){
                showToast("购买失败");
            }
            else {
                showToast("购买成功");
                finish();
            }
        }

        @Override
        public void onFail(String msg) {
            showToast("购买失败");
        }
    };


    @Override
    void initView() {
        setLayout_file(R.layout.fragment_food_by);

        tv_userid = (TextView)findViewById(R.id.tv_userid);
        ed_toaddress = (EditText)findViewById(R.id.ed_toaddress);
        tv_byshopname = (TextView)findViewById(R.id.tv_byshopname);
        tv_byfoodname = (TextView)findViewById(R.id.tv_byfoodname);
        tv_byfoodprice = (TextView)findViewById(R.id.tv_byfoodprice);
        ed_num = (EditText)findViewById(R.id.ed_num);
        tvt_sum = (TextView)findViewById(R.id.tvt_sum);
        ed_time = (EditText)findViewById(R.id.ed_time);
        btn_byreturn = (Button)findViewById(R.id.btn_byreturn);
        btn_buy = (Button)findViewById(R.id.btn_buy);

        String userid = getUser_name();
        SharedPreferences shop_sp = getSharedPreferences("shop_sp",MODE_PRIVATE);
        String price = shop_sp.getString("price","");

        tv_userid.setText(userid);
        tv_byshopname.setText(shop_sp.getString("shop_name",""));
        tv_byfoodname.setText(shop_sp.getString("food_name",""));
        tv_byfoodprice.setText("￥"+price);
        tvt_sum.setText(price);
    }

    @Override
    void initEvent() {

        ed_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shop_sp = getSharedPreferences("shop_sp",MODE_PRIVATE);
                String price = shop_sp.getString("price","");
                Double sum0 = Double.parseDouble(price) ;
                Double sum = Integer.valueOf(ed_num.getText().toString()).intValue() * sum0;
                String i = String.valueOf(sum);
                tvt_sum.setText(i);
            }
        });
        btn_byreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shop_sp = getSharedPreferences("shop_sp",MODE_PRIVATE);
                String user_id = shop_sp.getString("user_id","");
                String food_id = shop_sp.getString("food_id","");
                String num = ed_num.getText().toString();
                String sum = tvt_sum.getText().toString();
                String suggesttime = ed_time.getText().toString();

                ByModel byModel = new ByModel();
                byModel.getByBean(user_id,food_id,num,sum,suggesttime,tListener);
            }
        });
    }

    @Override
    void initData() {

    }
}
