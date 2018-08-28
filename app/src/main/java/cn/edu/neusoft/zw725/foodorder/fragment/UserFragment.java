package cn.edu.neusoft.zw725.foodorder.fragment;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import cn.edu.neusoft.zw725.foodorder.R;
import cn.edu.neusoft.zw725.foodorder.activity.ReviseActivity;
import cn.edu.neusoft.zw725.foodorder.bean.UserDateBean;
import cn.edu.neusoft.zw725.foodorder.listener.ListListener;
import cn.edu.neusoft.zw725.foodorder.listener.TListener;
import cn.edu.neusoft.zw725.foodorder.model.UserDateModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends BaseFragment {
    private TextView tv_uname;
    private TextView tv_mobilenum;
    private TextView tv_address;
    private TextView tv_comment;
    private Button btn_revise;
    private Button btn_logout;
    private TListener<UserDateBean> tListener = new TListener<UserDateBean>() {
        @Override
        public void onResponse(UserDateBean userDateBean) {
            tv_uname.setText(userDateBean.getUsername());
            tv_mobilenum.setText(userDateBean.getMobilenum());
            tv_address.setText(userDateBean.getAddress());
            tv_comment.setText(userDateBean.getComment());
        }

        @Override
        public void onFail(String msg) {

        }
    };

    @Override
    void initView() {
        tv_uname = (TextView)view.findViewById(R.id.tv_uname);
        tv_mobilenum = (TextView)view.findViewById(R.id.tv_mobilenum);
        tv_address = (TextView)view.findViewById(R.id.tv_address);
        tv_comment = (TextView)view.findViewById(R.id.tv_comment);
        btn_revise = (Button)view.findViewById(R.id.btn_revise);
        btn_logout = (Button)view.findViewById(R.id.btn_logout);
    }

    @Override
    void initEvent() {
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        btn_revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ReviseActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    void initData() {

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setLayout_flie(R.layout.fragment_user);
        view = inflater.inflate(getLayout_flie(), container, false);
        initView();
        initEvent();
        initData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        String user_id = getUser_id();
        showToast(user_id);
        UserDateModel userDateModel = new UserDateModel();
        userDateModel.getUserDate(user_id,tListener);
    }
}
