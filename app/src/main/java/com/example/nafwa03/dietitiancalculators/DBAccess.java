package com.example.nafwa03.dietitiancalculators;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by jab6677 on 1/11/17.
 */
public class DBAccess extends SQLiteOpenHelper {
    public static final String databaseName = "settings.db";
    public static final String table = "settings";


    public DBAccess(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}