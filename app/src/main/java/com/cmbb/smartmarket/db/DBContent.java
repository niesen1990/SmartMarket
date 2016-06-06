package com.cmbb.smartmarket.db;

import android.net.Uri;
import android.provider.BaseColumns;

public class DBContent implements BaseColumns {
    public static final String DB_NAME = "smarts.db";
    public static final String INTEGER_TYPE = " INTEGER,";
    public static final String TEXT_TYPE = " TEXT,";
    public static int VERSION = 1;

    public static class DBUser {

        public static final String TABLE_NAME = "UserAccount";
        public static final String USER_TOKEN = "loginToken";
        public static final String USER_NICK_NAME = "nickName";
        public static final String USER_HEAD_IMG = "userImg";
        public static final String USER_PHONE = "loginAccount";
        public static final String USER_MALE = "sex";
        public static final String USER_PROVINCE_ID = "province_id";
        public static final String USER_CITY_ID = "city_id";
        public static final String USER_PROVINCE = "provinceText";
        public static final String USER_CITY = "cityText";
        public static final String USER_INTRODUCE = "introduce";
        public static final String USER_LEVEL = "userLevel";
        public static final String USER_ID = "user_id";
        public static final String IM_USER_ID = "im_user_Id";
        public static String SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "( \n" +
                _ID + " INTEGER PRIMARY KEY," + "\n" +
                USER_TOKEN + TEXT_TYPE + "\n" +
                USER_HEAD_IMG + TEXT_TYPE + "\n" +
                USER_NICK_NAME + TEXT_TYPE + "\n" +
                USER_PHONE + TEXT_TYPE + "\n" +
                USER_MALE + INTEGER_TYPE + "\n" +
                USER_PROVINCE_ID + INTEGER_TYPE + "\n" +
                USER_CITY_ID + INTEGER_TYPE + "\n" +
                USER_PROVINCE + TEXT_TYPE + "\n" +
                IM_USER_ID + TEXT_TYPE + "\n" +
                USER_CITY + TEXT_TYPE + "\n" +
                USER_ID + INTEGER_TYPE + "\n" +
                USER_INTRODUCE + TEXT_TYPE + "\n" +
                USER_LEVEL + " INTEGER" + "\n" +
                " );";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS UserAccount";

        public static final String AUTHORITY = "com.cmbb.smartmarket.useraccount";

        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." + AUTHORITY;

        public static final String CONTENT_TYPE_ITEM = "vnd.android.cursor.item/vnd." + AUTHORITY;

        public static final int USERS = 1;

        public static final int USER = 2;

    }
}
