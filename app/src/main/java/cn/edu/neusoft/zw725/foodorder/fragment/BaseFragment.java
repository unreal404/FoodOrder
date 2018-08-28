package cn.edu.neusoft.zw725.foodorder.fragment;


import android.content.Context;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cn.edu.neusoft.zw725.foodorder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {
    protected int layout_flie = 0;
    View view = null;

    abstract void initView();

    abstract void initEvent();

    abstract void initData();


    public int getLayout_flie() {
        return layout_flie;
    }

    public void setLayout_flie(int layout_flie) {
        this.layout_flie = layout_flie;
    }

    public BaseFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(getLayout_flie(), container, false);
        initView();
        initEvent();
        initData();
        return view;
    }

    public String getUser_name() {
        SharedPreferences sp;
        sp = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getString("username", "");
    }

    public String getUser_password() {
        SharedPreferences sp;
        sp = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getString("userpass", "");
    }

    public String getUser_id(){
        SharedPreferences sp;
        sp = getActivity().getSharedPreferences("shop_sp",Context.MODE_PRIVATE);
        return sp.getString("user_id","");
    }
    public void showToast(String content){
        Toast.makeText(getActivity(),content,Toast.LENGTH_SHORT).show();
    }



}
