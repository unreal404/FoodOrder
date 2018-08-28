package cn.edu.neusoft.zw725.foodorder.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.edu.neusoft.zw725.foodorder.R;
import cn.edu.neusoft.zw725.foodorder.bean.RegBean;
import cn.edu.neusoft.zw725.foodorder.bean.UserDateBean;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.model.UpdateModel;
import cn.edu.neusoft.zw725.foodorder.model.UserDateModel;

public class ReviseActivity extends BaseActivity {
    private EditText ed_uname_rev;
    private EditText ed_password_rev;
    private EditText ed_password_rev2;
    private EditText ed_mobilenum_rev;
    private EditText ed_address_rev;
    private Button btn_revise_rev;
    private TListener<RegBean> tListener = new TListener<RegBean>() {
        @Override
        public void onResponse(RegBean regBean) {
            if(regBean.getSuccess().equals("0")){
                showToast("用户名已存在");
            }
            else {
                showToast("修改成功");
                finish();
            }
        }

        @Override
        public void onFail(String msg) {

        }
    };
    private TListener<UserDateBean> getlistener = new TListener<UserDateBean>() {
        @Override
        public void onResponse(UserDateBean userDateBean) {
            ed_uname_rev.setText(userDateBean.getUsername());
            ed_password_rev.setText(getUser_password());
            ed_password_rev2.setText(getUser_password());
            ed_mobilenum_rev.setText(userDateBean.getMobilenum());
            ed_address_rev.setText(userDateBean.getAddress());
        }

        @Override
        public void onFail(String msg) {

        }
    };

    @Override
    void initView() {
        setLayout_file(R.layout.activity_revise);

        ed_uname_rev = (EditText)findViewById(R.id.ed_uname_rev);
        ed_password_rev = (EditText)findViewById(R.id.ed_password_rev);
        ed_password_rev2 = (EditText)findViewById(R.id.ed_password_rev2);
        ed_mobilenum_rev = (EditText)findViewById(R.id.ed_mobilenum_rev);
        ed_address_rev = (EditText)findViewById(R.id.ed_address_rev);
        btn_revise_rev = (Button)findViewById(R.id.btn_revise_rev);


    }

    @Override
    void initEvent() {
        btn_revise_rev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed_uname_rev.getText().toString().trim().equals("")||ed_password_rev.getText().toString().trim().equals("")||
                        ed_password_rev2.getText().toString().trim().equals("")||ed_mobilenum_rev.getText().toString().trim().equals("")||
                        ed_address_rev.getText().toString().trim().equals("")){
                    showToast("信息不能为空");
                }else if(!ed_password_rev.getText().toString().equals(ed_password_rev2.getText().toString())){
                    showToast("两次密码不一致");
                }else {
                    String user_id = getUser_id();
                    String username = ed_uname_rev.getText().toString();
                    String userpass = ed_password_rev.getText().toString();
                    String mobilenum = ed_mobilenum_rev.getText().toString();
                    String address = ed_address_rev.getText().toString();

                    UpdateModel updateModel = new UpdateModel();
                    updateModel.getUpdate(user_id, username, userpass, mobilenum, address,tListener);
                }
            }
        });
    }

    @Override
    void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();

        String user_id = getUser_id();

        UserDateModel userDateModel = new UserDateModel();
        userDateModel.getUserDate(user_id,getlistener);
    }
}
