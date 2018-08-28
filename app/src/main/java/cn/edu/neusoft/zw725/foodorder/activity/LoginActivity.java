package cn.edu.neusoft.zw725.foodorder.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import cn.edu.neusoft.zw725.foodorder.R;
import cn.edu.neusoft.zw725.foodorder.bean.LoginBean;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.model.LoginModel;

public class LoginActivity extends BaseActivity {
    private EditText ed_user;
    private EditText ed_pass;
    private Button btn_login;
    private Button btn_reg;
    private String username,userpass;
    private CheckBox checkBox;

    private TListener<LoginBean> tListener = new TListener<LoginBean>() {
        @Override
        public void onResponse(LoginBean loginBean) {
            if(loginBean.getUserid().equals("0")){
                showToast("登入失败");
            }
            else {
                showToast("登入成功");
                saveUser();

                SharedPreferences shop_sp = getSharedPreferences("shop_sp",MODE_PRIVATE);
                SharedPreferences.Editor editor = shop_sp.edit();
                editor.putString("user_id",loginBean.getUserid());
                editor.commit();

                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }

        @Override
        public void onFail(String msg) {
            showToast("登入失败");
        }
    };



    @Override
    void initView() {
        setLayout_file(R.layout.activity_login);

        ed_user = (EditText)findViewById(R.id.ed_user);
        ed_pass = (EditText)findViewById(R.id.ed_pass);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_reg = (Button)findViewById(R.id.btn_reg);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        username = getUser_name();
        userpass = getUser_password();

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        ed_user.setText(message);

        boolean checkBoxflag =getFlag();

        if(checkBoxflag == true){
            ed_user.setText(username);
            ed_pass.setText(userpass);
            checkBox.setChecked(checkBoxflag);
        }
    }

    @Override
    void initEvent() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ed_user.getText().toString().trim().equals("")||ed_pass.getText().toString().equals("")){
                    showToast("用户名不能为空");
                }
                else {
                    //拿着用户名和密码去服务器判断数据是否正确。
                    String username = ed_user.getText().toString();
                    String userpass = ed_pass.getText().toString();
                    LoginModel loginModel =new LoginModel();
                    loginModel.getLoginBean(username,userpass,tListener);

                }
            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    void initData() {

    }


    public void saveUser(){
        SharedPreferences sp = getSharedPreferences("userInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username",ed_user.getText().toString());
        editor.putString("userpass",ed_pass.getText().toString());
        editor.putBoolean("checkBoxflag",checkBox.isChecked());
        editor.commit();
    }



}
