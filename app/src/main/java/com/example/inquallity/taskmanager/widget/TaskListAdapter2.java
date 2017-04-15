package com.example.inquallity.taskmanager.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.inquallity.taskmanager.content.Task;
import com.example.inquallity.taskmanager.content.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inquallity on 13-Apr-17.
 */

public class TaskListAdapter2 extends BaseAdapter {

    private List<Object> mItems = new ArrayList<Object>();

    public TaskListAdapter2() {
       final Task task = new Task();
        task.setName("Uber super task");
        task.setCreatedAt(System.currentTimeMillis());
        mItems.add(task);

        final User user = new User();
        user.setFirstName("Vasya");
        user.setLastName("Pypkin");
        mItems.add(user);
    }



    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);



    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=new TextView(parent.getContext());
            convertView.setMinimumHeight(120);
        }
        TextView textView = (TextView) convertView;

        if (position%2==0){
            Task task = (Task) getItem(position);
            textView.setText(task.getName());
        } else {
            User user = (User) getItem(position);
            textView.setText(user.getFirstName() + " " + user.getLastName());
        }


        return convertView;
    }


}
