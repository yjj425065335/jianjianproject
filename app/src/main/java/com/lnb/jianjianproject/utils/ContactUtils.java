package com.lnb.jianjianproject.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import com.lnb.jianjianproject.bean.ContactInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 读取手机通讯录
 */

public class ContactUtils {
    private static StringBuilder stringBuilder = new StringBuilder();

    public static List<ContactInfo> getAllContacts(Context context) {
        ArrayList<ContactInfo> contactInfos = new ArrayList<>();
        //生成ContentResolver对象
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(Uri.parse("content://com.android.contacts/contacts"), null, null, null, null);
        // 循环遍历
        if (cursor.moveToFirst()) {
            int idColumn = cursor.getColumnIndex(ContactsContract.Contacts._ID);
            int displayNameColumn = cursor
                    .getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            do {
                // 获得联系人的ID
                String contactId = cursor.getString(idColumn);
                // 获得联系人姓名
                String displayName = cursor.getString(displayNameColumn);
                ContactInfo contactInfo = new ContactInfo();
                contactInfo.setName(displayName);

                // 查看联系人有多少个号码，如果没有号码，返回0
                int phoneCount = cursor
                        .getInt(cursor
                                .getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                if (phoneCount > 0) {
                    // 获得联系人的电话号码列表
                    Cursor phoneCursor = context.getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                                    + "=" + contactId, null, null);
                    if (phoneCursor != null && phoneCursor.moveToFirst()) {
                        int i = 0;
                        do {
                            //遍历所有的联系人下面所有的电话号码
                            String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)).replace(" ", "").replace("-", "");
                            if (phoneNumber.length() == 11) {
                                if (i == 0) {
                                    stringBuilder.append(phoneNumber);
                                    i++;
                                } else {
                                    stringBuilder.append("," + phoneNumber);
                                }
                            }

                        } while (phoneCursor.moveToNext());
                        contactInfo.setPhone(stringBuilder.toString());
                        stringBuilder.setLength(0);
                    }
                }
                contactInfos.add(contactInfo);

            } while (cursor.moveToNext());
        }
        return contactInfos;
    }
}
