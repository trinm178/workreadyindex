package com.example.wri.Activity.Company;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.wri.Adapter.ExpandableListViewAdapter;
import com.example.wri.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Company_Search_Specialize_Main extends AppCompatActivity {

    ImageView id_back_company_search_specialize_main;
    ExpandableListView expandableListView;
    ExpandableListViewAdapter expandableAdapter;
    List<String> specializelist;
    HashMap<String,List<String>> specializeitemlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_company_search_specialize_main);
        expandableListView = findViewById(R.id.eplistview);
        showlist();
        expandableAdapter = new ExpandableListViewAdapter(this, specializelist, specializeitemlist);
        expandableListView.setAdapter(expandableAdapter);
        id_back_company_search_specialize_main = findViewById(R.id.id_back_company_search_specialize_main);



        id_back_company_search_specialize_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void showlist() {
        specializelist = new ArrayList<String>();
        specializeitemlist = new HashMap<String,List<String>>();
        specializelist.add("Mobile");
        specializelist.add("Quản trị nhân lực");
        specializelist.add("Kế toán");
        specializelist.add("Nhà hàng khách sạn");
        specializelist.add("Web");
        List<String> toppic1 = new ArrayList<>();
        toppic1.add("Dev Android");
        toppic1.add("Dev IOS");
        toppic1.add("React Native");
        toppic1.add("Design UI/UX");
        List<String> toppic2 = new ArrayList<>();
        toppic2.add("Toppic 1");
        toppic2.add("Toppic 2");
        toppic2.add("Toppic 3");
        toppic2.add("Toppic 4");
        List<String> toppic3 = new ArrayList<>();
        toppic3.add("Toppic 1");
        toppic3.add("Toppic 2");
        toppic3.add("Toppic 3");
        toppic3.add("Toppic 4");
        List<String> toppic4 = new ArrayList<>();
        toppic4.add("Toppic 1");
        toppic4.add("Toppic 2");
        toppic4.add("Toppic 3");
        toppic4.add("Toppic 4");
        List<String> toppic5 = new ArrayList<>();
        toppic5.add("Toppic 1");
        toppic5.add("Toppic 2");
        toppic5.add("Toppic 3");
        toppic5.add("Toppic 4");
        specializeitemlist.put(specializelist.get(0),toppic1);
        specializeitemlist.put(specializelist.get(1),toppic2);
        specializeitemlist.put(specializelist.get(2),toppic3);
        specializeitemlist.put(specializelist.get(3),toppic4);
        specializeitemlist.put(specializelist.get(4),toppic5);

    }
}