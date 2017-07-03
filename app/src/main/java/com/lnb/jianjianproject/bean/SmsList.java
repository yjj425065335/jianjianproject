package com.lnb.jianjianproject.bean;

import java.util.ArrayList;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 17/6/27.
 */

public class SmsList extends BmobObject {
    private ArrayList<String> list;

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public SmsList(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "SmsList{" +
                "list=" + list +
                '}';
    }
}
