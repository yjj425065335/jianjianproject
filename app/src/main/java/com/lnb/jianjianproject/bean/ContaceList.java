package com.lnb.jianjianproject.bean;

import java.util.ArrayList;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 17/6/27.
 */

public class ContaceList extends BmobObject {
    private ArrayList<ContactInfo>  list;

    public ContaceList(ArrayList<ContactInfo> list) {
        this.list = list;
    }

    public ArrayList<ContactInfo> getList() {
        return list;
    }

    public void setList(ArrayList<ContactInfo> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ContaceList{" +
                "list=" + list +
                '}';
    }
}
