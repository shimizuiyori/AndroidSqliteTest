package com.china_tanyo.androidsqlitetest;

/**
 * Created by gushi on 2017/10/18.
 */

import android.util.Log;

import com.china_tanyo.androidsqlitetest.entity.*;

import java.util.Objects;

public class App {

    private void logd (Object obj) {
        Log.d("gushi", obj.toString());
    }


    private String convert (Object obj) {

        switch (obj.getClass().getName()) {
            case "int": {

            } break;
            case java.lang.Integer.class.getName(): {

            } break;
        }

        return "";
    }


    public App () {

        person psn = new person(1, "顾世豪", 1, 24);

        String res = convert("12333");

        String s1 = int.class.getName();
        String s2 = String.class.getName();
    }
}
