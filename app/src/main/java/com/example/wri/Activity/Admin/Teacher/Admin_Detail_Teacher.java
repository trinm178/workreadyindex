package com.example.wri.Activity.Admin.Teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.wri.R;

public class Admin_Detail_Teacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__detail__teacher);
    }

    public void onBack(View view) {
        finish();
    }
}