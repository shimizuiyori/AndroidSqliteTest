package com.gushi.gsORM;

import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;

/**
 * Created by gushi on 2017/10/18.
 */

public class gsDB {

    private HashMap<String, gsTable> tables;

    public gsDB (String dbName) {
        SQLiteDatabase.openOrCreateDatabase(dbName, null);
    }

    public gsTable table(String tableName) {

        return tables.get(tableName);
    }
}
