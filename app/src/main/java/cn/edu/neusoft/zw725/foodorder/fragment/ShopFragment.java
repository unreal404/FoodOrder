package cn.edu.neusoft.zw725.foodorder.fragment;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.edu.neusoft.zw725.foodorder.R;
import cn.edu.neusoft.zw725.foodorder.activity.MainActivity;
import cn.edu.neusoft.zw725.foodorder.adapter.ShopAdapter;
import cn.edu.neusoft.zw725.foodorder.bean.AllShopBean;
import cn.edu.neusoft.zw725.foodorder.listener.ListListener;
import cn.edu.neusoft.zw725.foodorder.model.AllShopModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends BaseFragment {
    final List<AllShopBean> items = new ArrayList<AllShopBean>();

    RecyclerView recyclerView ;
    LinearLayoutManager layoutManager;
    ListListener<AllShopBean> listListener = new ListListener<AllShopBean>() {
        @Override
        public void onResponse(List<AllShopBean> list) {
            ShopAdapter shopAdapter = new ShopAdapter(getActivity(),list,R.layout.shop_card);
            recyclerView.setAdapter(shopAdapter);
        }

        @Override
        public void onFail(String msg) {

        }
    };

    @Override
    void initView() {
        recyclerView = (RecyclerView)view.findViewById(R.id.shop_rec);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));
    }

    @Override
    void initEvent() {

    }

    @Override
    void initData() {
        AllShopModel allShopModel = new AllShopModel();
        allShopModel.getAllShopBean(listListener);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setLayout_flie(R.layout.fragment_shop);
        view = inflater.inflate(getLayout_flie(), container, false);
        initView();
        initEvent();
        initData();
        return view;
    }


}
