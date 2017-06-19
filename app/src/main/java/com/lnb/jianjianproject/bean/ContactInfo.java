package com.lnb.jianjianproject.bean;

/**
 * Created by Administrator on 17/6/19.
 */

public class ContactInfo {
    public ContactInfo() {
    }


    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String phone;

    @Override
    public String toString() {
        return "ContactInfo{" +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
