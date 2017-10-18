package com.china_tanyo.androidsqlitetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.gushi.sqlite.gsDBHelper;
import com.google.gson.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gsDBHelper dbHelper = new gsDBHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", "段廷瑞");
//        contentValues.put("sex", "男");
//        contentValues.put("age", 26);
//        contentValues.put("address", "浙江省杭州市拱墅区");
//        contentValues.put("remark", "也是一个程序员");
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
