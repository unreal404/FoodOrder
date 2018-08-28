package cn.edu.neusoft.zw725.foodorder.activity;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cn.edu.neusoft.zw725.foodorder.R;

import cn.edu.neusoft.zw725.foodorder.fragment.CollectFragment;

import cn.edu.neusoft.zw725.foodorder.fragment.SearchFragment;
import cn.edu.neusoft.zw725.foodorder.fragment.ShopFragment;
import cn.edu.neusoft.zw725.foodorder.fragment.UserFragment;


public class MainActivity extends BaseActivity {
    LinearLayout tab_shop;
    LinearLayout tab_collect;
    LinearLayout tab_search;
    LinearLayout tab_user;
    ImageView img_shop;
    ImageView img_collect;
    ImageView img_search;
    ImageView img_user;
    Fragment fragment_shop;
    Fragment fragment_collect;
    Fragment fragment_search;
    Fragment fragment_user;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    void initView() {
        setLayout_file(R.layout.activity_main);

        tab_shop = (LinearLayout)findViewById(R.id.tab_shop);
        tab_collect = (LinearLayout)findViewById(R.id.tab_collect);
        tab_search = (LinearLayout)findViewById(R.id.tab_search);
        tab_user = (LinearLayout)findViewById(R.id.tab_user);
        img_shop = (ImageView)findViewById(R.id.img_shop);
        img_collect = (ImageView)findViewById(R.id.img_collect);
        img_search = (ImageView)findViewById(R.id.img_search);
        img_user = (ImageView)findViewById(R.id.img_user);


    }

    @Override
    void initEvent() {
        tab_shop.setOnClickListener(onClickListener);
        tab_collect.setOnClickListener(onClickListener);
        tab_search.setOnClickListener(onClickListener);
        tab_user.setOnClickListener(onClickListener);

        setSelect(0);
    }

    @Override
    void initData() {

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resetImage();
            switch (v.getId()){
                case R.id.tab_shop:
                    setSelect(0);
                    break;
                case R.id.tab_collect:
                    setSelect(1);
                    break;
                case R.id.tab_search:
                    setSelect(2);
                    break;
                case R.id.tab_user:
                    setSelect(3);
                    break;
                default:
                    break;
            }
        }
    };


    private void resetImage(){
        img_shop.setImageResource(R.drawable.ic_shop_normal);
        img_collect.setImageResource(R.drawable.ic_collect_normal);
        img_search.setImageResource(R.drawable.ic_search_normal);
        img_user.setImageResource(R.drawable.ic_user_normal);
    }

    private void setSelect(int i){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (i){
            case 0:
                if(fragment_shop == null){
                    fragment_shop = new ShopFragment();
                    fragmentTransaction.add(R.id.content,fragment_shop);
                }
                else{
                    fragmentTransaction.show(fragment_shop);
                }
                img_shop.setImageResource(R.drawable.ic_shop_pressed);
                break;
            case 1:
                if(fragment_collect == null){
                    fragment_collect = new CollectFragment();
                    fragmentTransaction.add(R.id.content,fragment_collect);
                }
                else
                {
                    fragmentTransaction.show(fragment_collect);
                }
                img_collect.setImageResource(R.drawable.ic_collect_pressed);
                break;
            case 2:
                if(fragment_search == null){
                    fragment_search = new SearchFragment();
                    fragmentTransaction.add(R.id.content,fragment_search);
                }
                else
                {
                    fragmentTransaction.show(fragment_search);
                }
                img_search.setImageResource(R.drawable.ic_search_pressed);
                break;
            case 3:
                if(fragment_user == null){
                    fragment_user = new UserFragment();
                    fragmentTransaction.add(R.id.content,fragment_user);
                }
                else
                {
                    fragmentTransaction.show(fragment_user);
                }
                img_user.setImageResource(R.drawable.ic_user_pressed);
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    private  void hideFragment(FragmentTransaction fragmentTransaction){
        if(fragment_shop!=null){
            fragmentTransaction.hide(fragment_shop);
        }
        if(fragment_collect!=null){
            fragmentTransaction.hide(fragment_collect);
        }
        if(fragment_search!=null){
            fragmentTransaction.hide(fragment_search);
        }
        if(fragment_user!=null){
            fragmentTransaction.hide(fragment_user);
        }
    }



}
