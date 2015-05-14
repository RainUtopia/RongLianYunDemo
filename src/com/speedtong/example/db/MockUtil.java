package com.speedtong.example.db;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by zhangyong on 2015/5/6.
 */
public class MockUtil {
    public static Random r = new Random();

    /**
     * 获取随机休眠值
     * @return
     */
    public static int getSleepTime() {
        return r.nextInt(70001) + 20000;
    }

    /**
     * 是否已到规定时间 (16:30)
     * @return
     */
    public static boolean isTimeUp() {
        Calendar up = Calendar.getInstance();
        up.set(Calendar.HOUR_OF_DAY, 16);
        up.set(Calendar.MINUTE, 30);

        if (System.currentTimeMillis() > up.getTimeInMillis()) {
            return true;
        }
        return false;
    }


    public static String txt() {
        return "即时通信测试--》" + Math.random() + "《---消息内容";
    }


    /**
     * 发送类型
     * 0：文本
     * 1：图片
     * 2：声音
     * 3：文件
     * @return
     */
    public static int getSendType() {
        return r.nextInt(4);
    }


    public static String getString(JSONObject json, String key) {
        String str = null;
        try {
            str = json.getString(key);
        } catch (Exception e) {
            str = "";
        }
        return str;
    }
}
