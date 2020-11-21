package com.example.wri.Activity.Company;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.wri.R;

public class Company_Specialize_List_Student extends AppCompatActivity {
    LinearLayout Ln_specialize_list__student;
    ImageView id_back_company_specialize_list_student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_company_specialize__list__student);
        init();
        id_back_company_specialize_list_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Ln_specialize_list__student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Company_Specialize_List_Student.this, Company_Detail_Student.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        id_back_company_specialize_list_student = findViewById(R.id.id_back_company_specialize_list_student);
                Ln_specialize_list__student = findViewById(R.id.Ln_specialize_list__student);
    }
}