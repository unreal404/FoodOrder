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
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import cn.edu.neusoft.zw725.foodorder.R;
import cn.edu.neusoft.zw725.foodorder.adapter.FoodAdapter;
import cn.edu.neusoft.zw725.foodorder.bean.FoodByShopBean;
import cn.edu.neusoft.zw725.foodorder.listener.ListListener;
import cn.edu.neusoft.zw725.foodorder.model.AllFoodModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment {
    private EditText ed_search;
    private Button btn_search;
    private RecyclerView recyclerView ;
    private LinearLayoutManager layoutManager;
    private ListListener<FoodByShopBean> listListener = new ListListener<FoodByShopBean>() {
        @Override
        public void onResponse(List<FoodByShopBean> list) {
            FoodAdapter foodAdapter = new FoodAdapter(getActivity(),list,R.layout.food_card);
            recyclerView.setAdapter(foodAdapter);
        }

        @Override
        public void onFail(String msg) {

        }
    };

    @Override
    void initView() {
        ed_search = (EditText)view.findViewById(R.id.ed_search);
        btn_search = (Button)view.findViewById(R.id.btn_search);

        recyclerView = (RecyclerView)view.findViewById(R.id.search_rec);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));
    }

    @Override
    void initEvent() {
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = ed_search.getText().toString();

                AllFoodModel allFoodModel = new AllFoodModel();
                allFoodModel.getAllFood(str,listListener);
            }
        });
    }

    @Override
    void initData() {

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setLayout_flie(R.layout.fragment_search);
        view = inflater.inflate(getLayout_flie(), container, false);
        initView();
        initEvent();
        initData();
        return view;
    }


}
