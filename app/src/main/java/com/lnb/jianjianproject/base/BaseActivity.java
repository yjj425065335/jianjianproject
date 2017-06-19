package com.lnb.jianjianproject.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lnb.jianjianproject.utils.ActivityCollector;
import com.lnb.jianjianproject.utils.LogUtil;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 17/4/12.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    protected Boolean isNetConnected;
    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//固定竖屏
        initView(savedInstanceState);//初始化布局
        //知晓当前界面对应的活动
        LogUtil.e(TAG, getClass().getSimpleName());
        ActivityCollector.addActivity(this);//将所有的activity添加到集合中
        ButterKnife.bind(this);//绑定控件
        initData();//初始化数据

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);//移除当前activity
    }

    /**
     * 初始化布局
     * @param savedInstanceState
     */
    abstract protected void initView(Bundle savedInstanceState);

    /**
     * 初始化数据
     */
    abstract protected void initData();

    //启动新的activity,传递参数
    public void goToActivity(Class Activity, Bundle bundle) {
        Intent intent = new Intent(this, Activity);
        //携带数据
        if (bundle != null && bundle.size() != 0) {
            intent.putExtra("data", bundle);
        }

        startActivity(intent);
    }

    //启动新的activity,不传递参数
    public void goToActivity(Class Activity) {
        Intent intent = new Intent(this, Activity);
        startActivity(intent);
    }

    //启动新的activity,传递参数,并且关闭
    public void goToActivityClose(Class Activity, Bundle bundle) {
        Intent intent = new Intent(this, Activity);
        //携带数据
        if (bundle != null && bundle.size() != 0) {
            intent.putExtra("data", bundle);
        }

        startActivity(intent);
        finish();
    }

    //启动新的activity,不传递参数,并且关闭
    public void goToActivityClose(Class Activity) {
        Intent intent = new Intent(this, Activity);
        startActivity(intent);
        finish();
    }

    //启动新的activity,移除之前的activity
    public void goToActivityRemove(Class Activity) {
        Intent intent = new Intent(this, Activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /**
     * 显示进度对话框
     */
    protected void showProgressDialog(String s) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(false);
        }
        if (s == null) {
            progressDialog.setMessage("努力请求中....");
        } else {
            progressDialog.setMessage(s);
        }
        progressDialog.show();
    }

    /**
     * 关闭进度对话框
     */
    protected void closeProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }


}
