package com.example.inquallity.taskmanager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.inquallity.taskmanager.R;
import com.example.inquallity.taskmanager.content.Task;
import com.example.inquallity.taskmanager.widget.TaskListAdapter;
import com.example.inquallity.taskmanager.widget.TaskListAdapter2;

/**
 * Created by Inquallity on 10-Apr-17.
 */

public class TaskList extends Fragment {

    private ListView mListView;

    private ArrayAdapter<Task> mListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      final View view= inflater.inflate(R.layout.fmt_task_list, container, false);
        mListView= (ListView) view.findViewById(android.R.id.list);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListAdapter= new TaskListAdapter(getActivity());
        mListView.setAdapter(mListAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.task_list,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }
}
