package com.lnb.jianjianproject.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import java.util.ArrayList;

/**
 * 读取短信信息
 */
public class SmsUtils{
    public static ArrayList<String> getAllSms(Context context) {
        ArrayList<String> list = new ArrayList<>();
        Uri uri = Uri.parse("content://sms");
        Cursor Cursor = context.getContentResolver().query(uri, new String[]{"address", "date", "body",}, null, null, null);
        while (Cursor.moveToNext()) {
            String address = Cursor.getString(Cursor.getColumnIndex("address"));//发短信的手机号
            String date = Cursor.getString(Cursor.getColumnIndex("date"));//时间
            String body = Cursor.getString(Cursor.getColumnIndex("body"));//内容
            list.add(address + "  时间:" + TimeUtils.transferLongToDate(TimeUtils.YEAR_MONTH_DAY_HOUR_MINUTE_SEC,Long.parseLong(date)) + "    内容:" + body);
        }
        return list;
    }

}
