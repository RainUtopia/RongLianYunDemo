package com.speedtong.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import static com.speedtong.example.db.MessageDao.*;

/**
 * Created by zhangyong on 2015/5/5.
 */
public class MySqliteHelper extends SQLiteOpenHelper {
    private static MySqliteHelper instance;

    private static final String CHAT_MSG_TABLE_CREATE = "create table if not exists " + TABLE_NAME + "(" +
            C_ID + " integer primary key autoincrement," +
            C_MESSAGE + " varchar(100) default ''," +
            C_MSG_TYPE + " varchar(50) default '' ," +
            C_MSG_ID + " varchar(100) default '' ," +
            C_MSG_TIME + " varchar(20) default ''," +
            C_DIRECT + " varchar(50) default ''," +
            C_FUSER + " varchar(50) default '' ," +
            C_TUSER + " varchar(50) default ''," +
            C_SUCCESS + " varchar(50) default 'TRUE'," +
            C_MSG_TIME2 + " varchar(20) default ''," +
            C_OFFON + " varchar(50) default 'ON'," +
            C_DATA_TYPE + " varchar(50) default 'RANDOM'," +
            C_CHANNEL + " varchar(50) default 'ANDROID'," +
            C_UUID + " varchar(50) default ''," +
            C_PRODUCT + " varchar(50) default 'YTX'," +
            C_BRAND + " varchar(50)," +
            C_REGAIN_TIME + " integer default 0," +
            C_SEND_TIME + " integer," +
            C_SEND_TIME2 + " datetime)";



    public MySqliteHelper(Context context) {
        super(context, Environment.getExternalStorageDirectory().getAbsolutePath()+"/yuntongxun/yuntongxun.db", null, 1);
    }


    public static MySqliteHelper getInstance(Context context) {
        if (instance == null) {
            instance = new MySqliteHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CHAT_MSG_TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
}
