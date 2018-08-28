package cn.edu.neusoft.zw725.foodorder.fragment;

import android.os.Bundle;
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
import cn.edu.neusoft.zw725.foodorder.adapter.CollectShopAdapter;
import cn.edu.neusoft.zw725.foodorder.bean.UserCollectionBean;
import cn.edu.neusoft.zw725.foodorder.listener.ListListener;
import cn.edu.neusoft.zw725.foodorder.model.UserCollectionModel;


public class CollectShopFragment extends BaseFragment {
    final List<UserCollectionBean> items = new ArrayList<UserCollectionBean>();

    RecyclerView recyclerView ;
    LinearLayoutManager layoutManager;
    private ListListener<UserCollectionBean> listListener = new ListListener<UserCollectionBean>() {
        @Override
        public void onResponse(List<UserCollectionBean> list) {
            CollectShopAdapter collectShopAdapter = new CollectShopAdapter(getActivity(),list,R.layout.collectshop_card);
            recyclerView.setAdapter(collectShopAdapter);
        }

        @Override
        public void onFail(String msg) {

        }
    };
    @Override
    void initView() {
        recyclerView = (RecyclerView)view.findViewById(R.id.collect_shop_rec);
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
        String user_id = getUser_id();

        UserCollectionModel userCollectionModel = new UserCollectionModel();
        userCollectionModel.getUserCollection(user_id,"0",listListener);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setLayout_flie(R.layout.fragment_collect_shop);
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

        UserCollectionModel userCollectionModel = new UserCollectionModel();
        userCollectionModel.getUserCollection(user_id,"0",listListener);
    }
}
