package com.china_tanyo.androidsqlitetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.gushi.sqlite.gsDBHelper;
import com.google.gson.*;
import com.china_tanyo.androidsqlitetest.entity.*;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App app = new App();

        person psn = new person(1, "顾世豪", 1, 24);

        Field[] fields = psn.getClass().getDeclaredFields();
        Field field = fields[1];
        Class c2 = field.getType();
        Type t1 = field.getGenericType();
        c2 = byte[].class;
        String str = c2.getName();
        String s1 = c2.getName();
        String s2 = c2.getCanonicalName();
        String s3 = c2.getSimpleName();

        gsDBHelper dbHelper = new gsDBHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", "周亚楠");
//        contentValues.put("sex", "男");
//        contentValues.put("age", 25);
//        contentValues.put("address", "浙江省杭州市萧山区");
//        contentValues.put("remark", "Pos机维护员");
//        db.insert("student", null, contentValues);

        Gson gson = new Gson();
        Cursor cursor = db.rawQuery("select * from student", null);
        int rowNum = cursor.getCount();
        int colNum = cursor.getColumnCount();
        cursor.moveToFirst();
        for (int y = 0; y < rowNum; ++y) {
            String[] rowData = new String[colNum];
            for (int x = 0; x < colNum; ++x) {
                rowData[x] = cursor.getString(x);
            }

            String jsonStr = gson.toJson(rowData);
            Log.d("gushi", jsonStr);

            cursor.moveToNext();
        }
    }
}
