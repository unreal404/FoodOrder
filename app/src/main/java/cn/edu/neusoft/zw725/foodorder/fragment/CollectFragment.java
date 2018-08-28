package cn.edu.neusoft.zw725.foodorder.fragment;


import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.edu.neusoft.zw725.foodorder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectFragment extends BaseFragment {
    private TextView tvinfo;
    private View view=null;
    private Context context;

    private PagerSlidingTabStrip pagersliding;
    private ViewPager viewpager;

    private CollectShopFragment collectShopFragment=null;
    private CollectFoodFragment collectFoodFragment=null;

    //获取当前屏幕的密度
    private DisplayMetrics dm;

    @Override
    void initView() {
        dm = getResources().getDisplayMetrics();//获取屏幕密度

        viewpager=(ViewPager)view.findViewById(R.id.viewPager);
        /*需要管理相互独立的并且隶属于Activity的Fragment使用FragmentManager（），
        而在Fragment中动态的添加Fragment要使用getChildFragmetManager（）来管理。*/
        viewpager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));

        pagersliding=(PagerSlidingTabStrip) view.findViewById(R.id.pagerslidingtabstrip);
        pagersliding.setViewPager(viewpager);
        setpagerstyle();//设置PagerSlidingTabStrip显示效果
    }

    @Override
    void initEvent() {

    }

    @Override
    void initData() {

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setLayout_flie(R.layout.fragment_collect);
        view = inflater.inflate(getLayout_flie(), container, false);
        initView();
        initEvent();
        initData();
        return view;
    }

    private void setpagerstyle() {
        // 设置Tab是自动填充满屏幕的
        pagersliding.setShouldExpand(true);
        // 设置Tab的分割线是透明的
        pagersliding.setDividerColor(Color.TRANSPARENT);
        // 设置Tab底部线的高度
        pagersliding.setUnderlineHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 1, dm));
        // 设置Tab Indicator的高度
        pagersliding.setIndicatorHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 4, dm));
        // 设置Tab标题文字的大小
        pagersliding.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab Indicator的颜色
        pagersliding.setIndicatorColor(Color.parseColor("#45c01a"));
        // 设置选中Tab文字的颜色 (这是自定义的一个方法)
        pagersliding.setSelectedTextColor(Color.parseColor("#45c01a"));
        // 取消点击Tab时的背景色
        pagersliding.setTabBackground(0);
    }

    //自定义ViewPagerAdapter子类
    private class MyPagerAdapter extends FragmentPagerAdapter {
        private String[] titles={"店铺","菜谱"};//显示在二级导航上的标题文字
        public MyPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];//确定选择当页导航上文字
        }
        @Override
        public int getCount() {
            return titles.length;//二级导航个数
        }

        @Override
        public Fragment getItem(int position) {
            //根据位置返回具体某个导航上对应的Fragment
            switch (position)
            {
                case 0:
                    if(collectShopFragment==null)
                    {
                        collectShopFragment=new CollectShopFragment();
                    }
                    return collectShopFragment;
                case 1:
                    if(collectFoodFragment==null)
                    {
                        collectFoodFragment=new CollectFoodFragment();
                    }
                    return collectFoodFragment;
                default:
                    return null;
            }


        }


    }
}


