package com.gc.inmemorydb;

import java.util.HashMap;

public class StaticCache {

    private static HashMap<String, String> sqlCostUid;

    public StaticCache() {
        this.sqlCostUid = new HashMap<String, String>();
    }

    public static String getSqlCostUid(String key) {
        return sqlCostUid.get(key);
    }

    public void setSqlCostUid(String key, String value) {
        this.sqlCostUid.put(key, value);
    }
}
