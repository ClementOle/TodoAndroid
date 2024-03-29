package com.colewski.todoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.colewski.todoandroid.Model.TaskModel;
import com.colewski.todoandroid.Service.TaskService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TaskService taskService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        taskService = new TaskService(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewTaskActivity.class);
                startActivity(intent);
            }
        });

        //Affiche toutes les tâches stockées dans la base de donnée
        showAllTask();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showAllTask() {
        //Récupère le textView
        TextView contentMainTextView = findViewById(R.id.contentMainTextView);
        //Récupère toutes les taches
        List<TaskModel> contentList = taskService.getAllTask();
        contentMainTextView.setText("");
        //Insère toutes les taches dans le textView
        for (TaskModel task : contentList) {
            contentMainTextView.append(task.getContent() + "\n");
        }
    }


}
