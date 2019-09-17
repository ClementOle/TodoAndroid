package com.colewski.todoandroid.Service;


import android.content.Context;
import android.database.Cursor;

import com.colewski.todoandroid.Database.TaskDatabase;
import com.colewski.todoandroid.Model.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    TaskDatabase taskDatabase;

    public TaskService(Context context) {
        taskDatabase = new TaskDatabase(context);
    }


    public List<TaskModel> getAllTask() {
        Cursor cursorAllTask = taskDatabase.getAllTask();

        List<TaskModel> listAllTask = new ArrayList<>();
        while (cursorAllTask.moveToNext()) {
            listAllTask.add(new TaskModel(cursorAllTask.getInt(0), cursorAllTask.getString(1)));
        }
        return listAllTask;
    }
}
