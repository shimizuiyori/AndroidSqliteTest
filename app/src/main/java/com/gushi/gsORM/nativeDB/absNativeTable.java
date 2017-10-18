package com.gushi.gsORM.nativeDB;

/**
 * Created by gushi on 2017/10/18.
 */

public abstract class absNativeTable {

    private String tableName;

    public absNativeTable (String ptableName) {

        this.tableName = ptableName;
    }
}
