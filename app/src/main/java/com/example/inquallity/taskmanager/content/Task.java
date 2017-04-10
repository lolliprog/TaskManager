package com.example.inquallity.taskmanager.content;

/**
 * Created by Inquallity on 10-Apr-17.
 */

public class Task {

    private String mName;

    private long mCreatedAt;

    private long mFinishedAt;

    public String getName() {
        return mName;
    }

    public long getCreatedAt() {
        return mCreatedAt;
    }

    public long getFinishedAt() {
        return mFinishedAt;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setCreatedAt(long createdAt) {
        mCreatedAt = createdAt;
    }

    public void setFinishedAt(long finishedAt) {
        mFinishedAt = finishedAt;
    }

}
