package com.example.wri.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wri.Adapter.Admin_listClass_Adapter;
import com.example.wri.Model.Classs;
import com.example.wri.R;
import com.example.wri.Service.APIService;
import com.example.wri.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Admin_List_Class extends AppCompatActivity {
    RecyclerView rcv_admin_listClass;
    Admin_listClass_Adapter listClass_adapter;
    ArrayList<Classs> classsArrayList;
    Button btn_create_class_adminlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__list__class);
        init();
        Getdata();
        btn_create_class_adminlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Admin_Add_Class.class));
            }
        });
    }

    private void init() {
        rcv_admin_listClass = findViewById(R.id.rcv_admin_listClass);
        btn_create_class_adminlist = findViewById(R.id.btn_create_class_adminlist);
    }

    private void Getdata() {
        DataService dataService = APIService.getService();
        Call<List<Classs>> callback = dataService.getAllClass();
        callback.enqueue(new Callback<List<Classs>>() {
            @Override
            public void onResponse(Call<List<Classs>> call, Response<List<Classs>> response) {
                classsArrayList = (ArrayList<Classs>)response.body();
                listClass_adapter = new Admin_listClass_Adapter(Admin_List_Class.this,classsArrayList);
                rcv_admin_listClass.setLayoutManager(new LinearLayoutManager(Admin_List_Class.this));
                rcv_admin_listClass.setAdapter(listClass_adapter);
            }

            @Override
            public void onFailure(Call<List<Classs>> call, Throwable t) {

            }
        });
    }
}