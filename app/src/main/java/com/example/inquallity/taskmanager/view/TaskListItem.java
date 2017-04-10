package com.example.inquallity.taskmanager.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.inquallity.taskmanager.R;
import com.example.inquallity.taskmanager.content.Task;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Inquallity on 10-Apr-17.
 */


public class TaskListItem extends LinearLayout {

    private static final DateFormat DATE_FORMAT = new java.text.SimpleDateFormat("SSS.ss.mm.HH.dd.MM.yyyy", Locale.US);

    private TextView mTitle;

    private TextView mCreatedAt;

    private TextView mFinishedAt;

    public TaskListItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void bindModel(Task task){
        mTitle.setText(task.getName());
        mCreatedAt.setText(DATE_FORMAT.format(new Date(task.getCreatedAt())));
        mFinishedAt.setText(DATE_FORMAT.format(new Date(task.getFinishedAt())));
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTitle = (TextView) findViewById(R.id.title);
        mCreatedAt = (TextView) findViewById(R.id.created_at);
        mFinishedAt = (TextView) findViewById(R.id.finished_at);
    }
}
