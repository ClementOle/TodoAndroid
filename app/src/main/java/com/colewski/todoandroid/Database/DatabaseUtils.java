package com.colewski.todoandroid.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseUtils extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "todo.db";


    public DatabaseUtils(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE task (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CONTENT TEXT)");

        db.execSQL("INSERT INTO task (CONTENT) VALUES ('Test 1')");
        db.execSQL("INSERT INTO task (CONTENT) VALUES ('Test 2')");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
