package com.lnb.jianjianproject.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.lnb.jianjianproject.R;
import com.lnb.jianjianproject.base.BaseFragment;
import com.lnb.jianjianproject.utils.LogUtil;

/**
 * Created by Administrator on 17/6/19.
 */

public class MyFragment extends BaseFragment {

    private View view;
    private String mPage;
    public static final String ARGS_PAGE = "args_page";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getString(ARGS_PAGE);
        LogUtil.e(TAG+"初始化",mPage);
    }

    @Override
    protected View initView() {
        view =View.inflate(mContext,R.layout.myfragment,null);
        return view;
    }

    @Override
    protected void initData() {
        TextView textView=view.findViewById(R.id.tv);
        LogUtil.e(TAG,mPage);
        if(!TextUtils.isEmpty(mPage))
        textView.setText("数据"+mPage);
    }
    public static MyFragment newInstance(String page) {
        Bundle args = new Bundle();
        args.putString(ARGS_PAGE, page);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
