package com.example.wri.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.wri.R;

public class Admin_Main extends AppCompatActivity {
    LinearLayout ln_admin_class,ln_admin_teacher,ln_admin_company,ln_admin_student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__main);
        init();
        ln_admin_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin_Main.this,Admin_List_Class.class));
            }
        });
        ln_admin_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin_Main.this,Admin_Create_Teacher.class));
            }
        });
        ln_admin_company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin_Main.this,Admin_Company_List.class));
            }
        });
        ln_admin_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin_Main.this,Admin_List_Student.class));
            }
        });
    }

    private void init() {
        ln_admin_class = findViewById(R.id.ln_admin_class);
        ln_admin_teacher = findViewById(R.id.ln_admin_teacher);
        ln_admin_company = findViewById(R.id.ln_admin_company);
        ln_admin_student = findViewById(R.id.ln_admin_student);
    }
}