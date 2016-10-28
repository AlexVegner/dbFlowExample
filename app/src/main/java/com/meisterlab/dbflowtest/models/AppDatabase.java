package com.meisterlab.dbflowtest.models;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by alex on 10/28/16.
 */

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {

    public static final String NAME = "AppDatabase"; // we will add the .db extension

    public static final int VERSION = 1;
}

