package com.lnb.jianjianproject.utils;

import android.widget.Toast;

import com.lnb.jianjianproject.app.MyApplication;

/**
 * Created by Administrator on 17/6/19.
 */

public class ToastUtils {

    /**
     * 吐司工具类
     * 传入true,代表短时间
     * 传入false代表长时间
     */
    private static Toast toast;
    public static void showToast(String content,boolean b) {
        if (toast == null) {
            if(b){
                toast = Toast.makeText(MyApplication.getContext(),
                        content,
                        Toast.LENGTH_SHORT);
            }else{
                toast = Toast.makeText(MyApplication.getContext(),
                        content,
                        Toast.LENGTH_LONG);
            }

        } else {
            toast.setText(content);
        }
        toast.show();
    }

}
