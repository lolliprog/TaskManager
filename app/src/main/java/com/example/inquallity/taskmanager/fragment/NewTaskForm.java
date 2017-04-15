package com.example.inquallity.taskmanager.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

/**
 * @author Olga Aleksandrova on 15.04.17.
 */

public class NewTaskForm extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final EditText input = new EditText(getActivity());
        return new AlertDialog.Builder(getActivity())
                .setView(input)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (getTargetFragment() instanceof TaskList) {
                            ((TaskList) getTargetFragment()).onNewTaskFormOkClick(input.getText().toString());

                        }
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .create();

    }
}
