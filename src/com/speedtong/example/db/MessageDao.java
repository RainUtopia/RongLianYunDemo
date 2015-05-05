package com.speedtong.example.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import java.util.Map;

/**
 * Created by zhangyong on 2015/5/5.
 */
public class MessageDao {
    private static MessageDao messageDao;
    private SQLiteDatabase db;

    public static final String TABLE_NAME = "yun_tong_xun";
    public static final String C_ID = "id";
    public static final String C_MESSAGE = "mes";
    public static final String C_MSG_TYPE = "mesType";
    public static final String C_MSG_ID = "messageId";
    public static final String C_MSG_TIME = "recTime";
    public static final String C_DIRECT = "actionType";
    public static final String C_FUSER = "fromUser";
    public static final String C_TUSER = "toUser";
    public static final String C_SUCCESS = "success";
    public static final String C_MSG_TIME2 = "recTime2";
    public static final String C_OFFON = "offOn";
    public static final String C_DATA_TYPE = "dataType";
    public static final String C_CHANNEL = "channel";
    public static final String C_UUID = "uuid";
    public static final String C_PRODUCT = "product";
    public static final String C_BRAND = "phoneCaption";


    private MessageDao(Context context) {
        db = MySqliteHelper.getInstance(context).getWritableDatabase();
    }

    public static MessageDao getInstance(Context context) {
        if (messageDao == null) {
            messageDao = new MessageDao(context);
        }
        return messageDao;
    }

    public void insert(Map<String, String> map) {
        ContentValues values = new ContentValues();
        values.put(C_MESSAGE, String.valueOf(map.get(C_MESSAGE)));
        values.put(C_MSG_TYPE, String.valueOf(map.get(C_MSG_TYPE)));
        values.put(C_MSG_ID, String.valueOf(map.get(C_MSG_ID)));
        values.put(C_MSG_TIME, String.valueOf(map.get(C_MSG_TIME)));
        values.put(C_DIRECT, String.valueOf(map.get(C_DIRECT)));
        values.put(C_FUSER, String.valueOf(map.get(C_FUSER)));
        values.put(C_TUSER, String.valueOf(map.get(C_TUSER)));
        values.put(C_SUCCESS, String.valueOf(map.get(C_SUCCESS)));
        values.put(C_MSG_TIME2, String.valueOf(map.get(C_MSG_TIME2)));
        values.put(C_OFFON, String.valueOf(map.get(C_OFFON)));
        values.put(C_DATA_TYPE, String.valueOf(map.get(C_DATA_TYPE)));
        values.put(C_UUID, String.valueOf(map.get(C_UUID)));
        values.put(C_BRAND, Build.BRAND + Build.MODEL);

        db.insert(TABLE_NAME, null, values);
    }


    public void updateSuccess(String msgid, String success) {
        ContentValues values = new ContentValues();
        values.put(C_SUCCESS, success);
        db.update(TABLE_NAME, values, C_MSG_ID.concat(" = ?"), new String[]{msgid});
    }
}
