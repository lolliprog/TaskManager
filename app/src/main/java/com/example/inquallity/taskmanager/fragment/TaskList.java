package com.example.inquallity.taskmanager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.inquallity.taskmanager.R;
import com.example.inquallity.taskmanager.content.Task;
import com.example.inquallity.taskmanager.widget.TaskListAdapter;

/**
 * Created by Inquallity on 10-Apr-17.
 */

public class TaskList extends Fragment {

    private static final int DELETED_ID = 1;

    private ListView mListView;

    private ArrayAdapter<Task> mListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fmt_task_list, container, false);
        mListView = (ListView) view.findViewById(android.R.id.list);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListAdapter = new TaskListAdapter(getActivity());
        mListView.setAdapter(mListAdapter);
        registerForContextMenu(mListView);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.task_list, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_new) {
            NewTaskForm form = new NewTaskForm();
            form.setTargetFragment(this, 1);
            form.show(getFragmentManager(), NewTaskForm.class.getName());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onNewTaskFormOkClick(String taskName) {

        Task task = new Task();
        task.setName(taskName);
        task.setCreatedAt(System.currentTimeMillis());
        mListAdapter.add(task);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, DELETED_ID, 0, "Del the item");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == DELETED_ID) {
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Task task = mListAdapter.getItem(acmi.position);
            mListAdapter.remove(task);
            mListAdapter.notifyDataSetChanged();

            return true;

        }

        return super.onContextItemSelected(item);
    }
}
