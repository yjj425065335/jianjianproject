package com.lnb.jianjianproject.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化时间
 */

public class TimeUtils {
    public static String YEAR_MONTH_DAY = "yyyy-MM-dd";
    public static String YEAR_MONTH_DAY_HOUR_MINUTE_SEC= "yyyy-MM-dd HH:mm:ss";

    public static  String transferLongToDate(String dateFormat,Long millSec){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date= new Date(millSec);
        return sdf.format(date);
    }
}
