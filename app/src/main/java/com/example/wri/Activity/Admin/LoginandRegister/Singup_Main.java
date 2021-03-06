package com.example.wri.Activity.Admin.LoginandRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.wri.R;

public class Singup_Main extends AppCompatActivity {
    Animation topanim,bottomanim;
    LinearLayout linearLayout;
    ImageView iconapp;
    Button btn_signup_as_student,btn_signup_as_teacher,btn_signup_as_company,btn_signup_as_admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_singup__main);
        init();
        //set animation
        topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_animatoion);
        linearLayout.setAnimation(topanim);
        iconapp.setAnimation(bottomanim);
        //
        btn_signup_as_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Singup_Main.this,Signup_as_student.class);
                startActivity(intent);
            }
        });

        btn_signup_as_company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Singup_Main.this,Signup_as_company.class);
                startActivity(intent);
            }
        });

    }

    private void init() {
        linearLayout = findViewById(R.id.linearLayout2);
        iconapp = findViewById(R.id.icon_app2);
        btn_signup_as_student = findViewById(R.id.btn_signup_as_student);
        btn_signup_as_teacher = findViewById(R.id.btn_signup_as_teacher);
        btn_signup_as_company = findViewById(R.id.btn_signup_as_company);
        btn_signup_as_admin = findViewById(R.id.btn_signup_as_admin);
    }
}