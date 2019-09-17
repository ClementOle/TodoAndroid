package com.colewski.todoandroid.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TaskDatabase {

    private DatabaseUtils databaseUtils;
    private SQLiteDatabase db;

    public TaskDatabase(Context context) {
        databaseUtils = new DatabaseUtils(context);
        db = databaseUtils.getWritableDatabase();
    }

    public Cursor getAllTask() {
        System.out.println("fdsfds");
        return db.rawQuery("SELECT * FROM task ", null);
    }

}
