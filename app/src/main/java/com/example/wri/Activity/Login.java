package com.example.wri.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wri.Activity.Admin.Admin_Main;
import com.example.wri.Activity.Company.Company_Main;
import com.example.wri.Activity.Student.Student_Main;
import com.example.wri.Model.Users;
import com.example.wri.R;
import com.example.wri.Service.APIService;
import com.example.wri.Service.DataService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    TextView gotoRegister;
    EditText email_login, password_login;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Singup_Main.class));
                finish();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void validate() {
        final String email = email_login.getText().toString().trim();
        final String password = password_login.getText().toString().trim();
        if (TextUtils.isEmpty(email)){
            email_login.setError("Email Không được để trống");
            return;
        }else
        if (TextUtils.isEmpty(password)){
            password_login.setError("Password Không được để trống");
            return;
        }else {
            DataService dataService = APIService.getService();
            Call<Users>  callback = dataService.login(email,password);
            callback.enqueue(new Callback<Users>() {
                @Override
                public void onResponse(Call<Users> call, Response<Users> response) {
                    if(response.body().getIsSuccess() == 1){
                        //get email
                        String user = response.body().getEmail();
                        startActivity(new Intent(Login.this, Student_Main.class));
                        Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    if(response.body().getIsSuccess() == 3){
                        String user = response.body().getEmail();
                        startActivity(new Intent(Login.this, Company_Main.class));
                        Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("tag",response.body().getMessage() + response.body().getIsSuccess() + email + password);
                    }
                    if(response.body().getIsSuccess() == 0){
                        String user = response.body().getEmail();
                        startActivity(new Intent(Login.this, Admin_Main.class));
                        Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("tag",response.body().getMessage() + response.body().getIsSuccess() + email + password);
                    }
                    if(response.body().getIsSuccess() == 404){
                        Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("tag",response.body().getMessage() + response.body().getIsSuccess() + email + password);
                    }
                }
                @Override
                public void onFailure(Call<Users> call, Throwable t) {
                    Toast.makeText(Login.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void init() {
        btn_login = findViewById(R.id.btn_Login);
        email_login = findViewById(R.id.email_login);
        password_login = findViewById(R.id.password_login);
        gotoRegister = findViewById(R.id.gotoRegister);
    }




}