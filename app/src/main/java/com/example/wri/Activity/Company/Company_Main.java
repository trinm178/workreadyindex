package com.example.wri.Activity.Company;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import com.example.wri.R;

public class Company_Main extends AppCompatActivity {
    Button search_job_desc_main_company;
    ImageView contacted_main_company,favorite_main_company,search_main_company,update_main_company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_main);
        init();
          //click search item in edittext
         search_job_desc_main_company.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(Company_Main.this, Company_Add_Search_Desc.class);
                 startActivity(intent);
             }
         });


        search_main_company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Company_Main.this, Company_Search_Specialize_Main.class);
                startActivity(intent);
            }
        });
    }
    private void init() {
        contacted_main_company = findViewById(R.id.contacted_main_company);
        favorite_main_company = findViewById(R.id.favorite_main_company);
        search_main_company = findViewById(R.id.search_main_company);
        update_main_company = findViewById(R.id.update_main_company);
        search_job_desc_main_company = findViewById(R.id.search_job_desc_main_company);

    }


}