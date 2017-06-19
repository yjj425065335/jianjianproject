package com.lnb.jianjianproject.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 17/3/1.
 */

public abstract  class BaseFragment extends Fragment {
    /**
     * 上下文
     */
    protected Context mContext;
    protected String TAG = "BaseFragment";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = initView();
        ButterKnife.bind(this,view);
        return view;
    }

    /**
     * 由子类实现该方法，创建自己的视图
     * @return
     */
    protected abstract View initView() ;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }
    /**
     * 子类，需要初始化数据，联网请求数据并且绑定数据，等重写该方法
     */
    protected abstract void initData();

}
