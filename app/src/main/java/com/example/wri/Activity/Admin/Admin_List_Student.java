package com.example.wri.Activity.Admin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.wri.Activity.Student.Student_Main;
import com.example.wri.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.wri.Adapter.Admin_List_AllStudent_Adapter;
import com.example.wri.Adapter.Admin_listClass_Adapter;
import com.example.wri.Model.Classs;
import com.example.wri.Model.Students;
import com.example.wri.R;
import com.example.wri.Service.APIService;
import com.example.wri.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Admin_List_Student extends AppCompatActivity {
    RecyclerView rcv_admin_liststudent;
    Admin_List_AllStudent_Adapter liststudent_adapter;
    ArrayList<Students> studentsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__list__student);
        init();
        Getdata();
    }

    private void Getdata() {
        DataService dataService = APIService.getService();
        Call<List<Students>> callback = dataService.getAllStudent_admin();
        callback.enqueue(new Callback<List<Students>>() {
            @Override
            public void onResponse(Call<List<Students>> call, Response<List<Students>> response) {
                studentsArrayList = (ArrayList<Students>)response.body();
                liststudent_adapter = new Admin_List_AllStudent_Adapter(Admin_List_Student.this,studentsArrayList);
                rcv_admin_liststudent.setLayoutManager(new LinearLayoutManager(Admin_List_Student.this));
                rcv_admin_liststudent.setAdapter(liststudent_adapter);
            }

            @Override
            public void onFailure(Call<List<Students>> call, Throwable t) {

            }
        });
    }

    private void init() {
        rcv_admin_liststudent = findViewById(R.id.rcv_admin_listStudent);
    }
}