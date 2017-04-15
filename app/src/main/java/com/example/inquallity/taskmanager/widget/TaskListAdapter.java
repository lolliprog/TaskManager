package com.example.inquallity.taskmanager.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.inquallity.taskmanager.R;
import com.example.inquallity.taskmanager.content.Task;
import com.example.inquallity.taskmanager.view.TaskListItem;

/**
 * Created by Inquallity on 10-Apr-17.
 */

public class TaskListAdapter extends ArrayAdapter <Task> {

    private LayoutInflater mInflater;

    public TaskListAdapter(Context context) {
        super(context, R.layout.li_task_list);
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.li_task_list, parent, false);
        }
        final TaskListItem item = (TaskListItem) convertView;
        item.bindModel(getItem(position));

        return convertView;
    }


}
