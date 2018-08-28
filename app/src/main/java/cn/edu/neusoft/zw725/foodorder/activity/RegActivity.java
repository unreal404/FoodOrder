package cn.edu.neusoft.zw725.foodorder.activity;

import android.content.Intent;;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.edu.neusoft.zw725.foodorder.R;
import cn.edu.neusoft.zw725.foodorder.bean.RegBean;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.model.RegModel;

public class RegActivity extends BaseActivity {
    private EditText ed_reguser;
    private EditText ed_regpass;
    private EditText ed_repass2;
    private EditText ed_mobilenum;
    private EditText ed_address;
    private EditText ed_comment;
    private Button btn_rreg;

    private TListener<RegBean> tListener = new TListener<RegBean>() {
        @Override
        public void onResponse(RegBean regBean) {
            if(regBean.getSuccess().equals("0")){
                showToast("用户已存在");
            }
            else {
                showToast("注册成功");
                String message = ed_reguser.getText().toString();
                Intent intent=new Intent(RegActivity.this,LoginActivity.class);
                intent.putExtra("message",message);
                startActivityForResult(intent,1);
            }
        }

        @Override
        public void onFail(String msg) {
            showToast("注册失败");
        }
    };

    @Override
    void initView() {
        setLayout_file(R.layout.activity_reg);

        ed_reguser = (EditText)findViewById(R.id.ed_reguser);
        ed_regpass = (EditText)findViewById(R.id.ed_regpass);
        ed_repass2 = (EditText)findViewById(R.id.ed_regpass2);
        ed_mobilenum = (EditText)findViewById(R.id.ed_mobilenum);
        ed_address = (EditText)findViewById(R.id.ed_address);
        ed_comment = (EditText)findViewById(R.id.ed_comment);
        btn_rreg = (Button)findViewById(R.id.btn_rreg);
    }

    @Override
    void initEvent() {
        btn_rreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed_reguser.getText().toString().trim().equals("")||ed_regpass.getText().toString().trim().equals("")||
                        ed_mobilenum.getText().toString().trim().equals("")||ed_address.getText().toString().trim().equals("")||
                        ed_comment.getText().toString().trim().equals("")){
                    showToast("信息不能为空");
                }
                else if(!ed_regpass.getText().toString().equals(ed_repass2.getText().toString())){
                    showToast("两次密码不一致");
                }else {
                    String username = ed_reguser.getText().toString();
                    String userpass = ed_regpass.getText().toString();
                    String mobilenum = ed_mobilenum.getText().toString();
                    String address = ed_address.getText().toString();
                    String comment = ed_comment.getText().toString();

                    RegModel regModel = new RegModel();
                    regModel.getRegBean(username,userpass,mobilenum,address,comment,tListener);
                }
            }
        });
    }

    @Override
    void initData() {

    }


}
