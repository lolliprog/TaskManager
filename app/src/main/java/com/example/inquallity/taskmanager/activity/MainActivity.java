package com.example.inquallity.taskmanager.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inquallity.taskmanager.R;
import com.example.inquallity.taskmanager.fragment.TaskList;

public class MainActivity extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        if (savedInstanceState==null){
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.list_frame, new TaskList())
                    .commit();
        }
    }
}
