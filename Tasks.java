package com.example.admin.tasks;

import android.app.Activity;
import android.os.Bundle;

public class Tasks extends Activity {

    String mCategory;
    String mSubject;
    String mText;
    String mDate;
    int mRate;
    String mStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Tasks);


    }

    public void setCategory(String category) {
        this.mCategory = category;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setSubject(String subject) {
        this.mSubject = subject;
    }

    public String getSubject() {
        return mSubject;
    }

    public void setText(String text) {
        this.mText = text;
    }

    public String getText() {
        return mText;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public String getDate() {
        return mDate;
    }

    public void setRate(int rate) {
        this.mRate = rate;
    }

    public int getRate() {
        return mRate;
    }

    public void setStatus(String status) {
        this.mStatus = status;
    }

    public String getStatus() {
        return mStatus;
    }
}
