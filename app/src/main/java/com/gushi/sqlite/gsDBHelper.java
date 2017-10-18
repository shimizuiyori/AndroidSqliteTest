package com.gushi.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gushi on 2017/10/17.
 */

public class gsDBHelper extends SQLiteOpenHelper {

    private String dbName = "test.db";
    private String tableName = "student";
    private SQLiteDatabase db = null;

    public gsDBHelper(Context context) {
        super(context, "test.db", null, 1);
    }

    public gsDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public gsDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        this.db = sqLiteDatabase;
        sqLiteDatabase.execSQL("create table student(id integer primary key autoincrement, " +
                                                    "name text not null, " +
                                                    "sex integer not null, " +
                                                    "age integer not null, " +
                                                    "address text, " +
                                                    "remark text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void test () {

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "顾世豪");
        contentValues.put("sex", "男");
        contentValues.put("age", 24);
        contentValues.put("address", "浙江省杭州市萧山区");
        contentValues.put("remark", "程序员");
        this.db.insert("student", null, contentValues);
    }
}
