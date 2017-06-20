package com.lnb.jianjianproject.activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lnb.jianjianproject.R;
import com.lnb.jianjianproject.base.BaseActivity;
import com.lnb.jianjianproject.fragments.MyFragment;
import com.lnb.jianjianproject.utils.ToastUtils;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity  implements CommonPopupWindow.ViewInterface{


    @BindView(R.id.tl)
    TabLayout tl;
    @BindView(R.id.vp)
    ViewPager vp;
    private ArrayList<Fragment> list;
    private ArrayList<String> list1;
    private CommonPopupWindow popupWindow;
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {
        list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add("标题" + i);
        }
        list = new ArrayList<>();
        list.add(MyFragment.newInstance("1"));
        list.add(MyFragment.newInstance("2"));
        list.add(MyFragment.newInstance("3"));
        list.add(MyFragment.newInstance("4"));
        list.add(MyFragment.newInstance("5"));
        list.add(MyFragment.newInstance("6"));
        list.add(MyFragment.newInstance("7"));
        list.add(MyFragment.newInstance("8"));
        list.add(MyFragment.newInstance("9"));
        list.add(MyFragment.newInstance("10"));
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return list1.get(position);
            }
        });
        tl.setupWithViewPager(vp);
        tl.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    public void up(View v) {
//        View upView = LayoutInflater.from(this).inflate(R.layout.popup_up, null);
//        //测量View的宽高
//        CommonUtil.measureWidthAndHeight(upView);
//        popupWindow = new CommonPopupWindow.Builder(this)
//                .setView(R.layout.popup_up)
//                .setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, upView.getMeasuredHeight())
//                .setBackGroundLevel(0.5f)//取值范围0.0f-1.0f 值越小越暗
//                .setAnimationStyle(R.style.AnimUp)
//                .setViewOnclickListener(this)
//                .create();
//        popupWindow.showAtLocation(findViewById(android.R.id.content), Gravity.BOTTOM, 0, 0);
    }

    public void down(View v) {
//        popupWindow = new CommonPopupWindow.Builder(this)
//                .setView(R.layout.popup_down)
//                .setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
//                .setAnimationStyle(R.style.AnimDown)
//                .setViewOnclickListener(this)
//                .setOutsideTouchable(true)
//                .create();
//        popupWindow.showAsDropDown(view);
    }

    public void right(View v) {
        popupWindow = new CommonPopupWindow.Builder(this)
                .setView(R.layout.popup_left_or_right)
                .setWidthAndHeight(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .setAnimationStyle(R.style.AnimHorizontal)
                .setViewOnclickListener(this)
                .create();
        popupWindow.showAsDropDown(v, v.getWidth(), -v.getHeight());
    }

    @Override
    public void getChildView(View view, int layoutResId) {
        switch (layoutResId){
            case R.layout.popup_left_or_right:
                TextView tv_like = (TextView) view.findViewById(R.id.tv_like);
                TextView tv_hate = (TextView) view.findViewById(R.id.tv_hate);
                tv_like.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.showToast("赞一个",true);
                        popupWindow.dismiss();
                    }
                });
                tv_hate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.showToast("踩一个",true);
                        popupWindow.dismiss();
                    }
                });
                break;
        }

    }
}
