package com.lnb.jianjianproject.utils;

import android.os.Environment;

import com.lnb.jianjianproject.app.MyApplication;

import java.io.File;

/**
 * Created by Administrator on 17/6/19.
 */

public class FileUtils {
    private static File photoDir = null;

    /**
     * 获取手机文件目录
     * @return
     */
    public static File getFileDir() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {//判断sd卡是否挂载
            photoDir = MyApplication.getContext().getExternalFilesDir("");
        } else {//手机内部存储
            photoDir = MyApplication.getContext().getFilesDir();
        }
        return photoDir;
    }
}
