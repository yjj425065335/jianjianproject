package com.lnb.jianjianproject.activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.lnb.jianjianproject.R;
import com.lnb.jianjianproject.base.BaseActivity;
import com.lnb.jianjianproject.fragments.MyFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tl)
    TabLayout tl;
    @BindView(R.id.vp)
    ViewPager vp;
    private ArrayList<Fragment> list;
    private ArrayList<String> list1;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {
        list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add("标题"+i);
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

}
