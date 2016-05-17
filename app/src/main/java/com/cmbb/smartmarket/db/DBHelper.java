package com.cmbb.smartmarket.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private final String TAG = DBHelper.class.getSimpleName();

    public DBHelper(Context context) {
        super(context, DBContent.DB_NAME, null, DBContent.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBContent.DBUser.SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBContent.DBUser.DELETE_TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void delete(SQLiteDatabase db) {
        db.execSQL(DBContent.DBUser.DELETE_TABLE);
        onCreate(db);
    }

}
