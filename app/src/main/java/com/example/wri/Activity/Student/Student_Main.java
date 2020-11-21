package com.example.wri.Activity.Student;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wri.Activity.Login;
import com.example.wri.R;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Student_Main extends AppCompatActivity {
    TextView txtTitleUserStu, pointSpec, pointSkill, pointEng, pointAttitude;
    String stuID;

    ViewPager viewPager;
    //    TabLayout tabLayout;
    Student_Fragment_Course student_fragment_course;
    Student_Fragment_Point student_fragment_point;
    Button btn_showdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_student);

        init();

        student_fragment_course = new Student_Fragment_Course();
        student_fragment_point = new Student_Fragment_Point();

        //setcolor text hover and non click
//        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#2c5ca4"));
//        tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
//        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#2c5ca4"));
//        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);

        viewPagerAdapter.addFragment(student_fragment_course);
        viewPagerAdapter.addFragment(student_fragment_point);

        viewPager.setAdapter(viewPagerAdapter);



//        txtTitleUserStu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showpopup(v);
//            }
//        });
    }
//    public void showpopup(View v ){
//        PopupMenu popup = new PopupMenu(this,v);
//        popup.inflate(R.menu.menu);
//        popup.show();
//        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.info_student:
//                        Toast.makeText(Student_Main.this, "Thong tin ca nhan", Toast.LENGTH_SHORT).show();
//                        return true;
//                    case R.id.logout_student:
//                        FirebaseAuth.getInstance().signOut();
//                        startActivity(new Intent(getApplicationContext(), Login.class));
//                        finish();
//                        return true;
//                    default:
//                        return false;
//                }
//            }
//        });
//    }
    private void init() {
        txtTitleUserStu = findViewById(R.id.txtTitleUserStu);
        pointSpec = findViewById(R.id.pointSpecialize);
        pointSkill = findViewById(R.id.pointSkill);
        pointEng = findViewById(R.id.pointEnglish);
        pointAttitude = findViewById(R.id.pointAttitude);
        btn_showdetail = findViewById(R.id.btn_showdetail);
//        tabLayout = findViewById(R.id.tab_layout_2);
        viewPager = findViewById(R.id.view_pager_2);
    }
//    public void ClickLogout(View view) {
//        FirebaseAuth.getInstance().signOut();
//        startActivity(new Intent(getApplicationContext(), Login.class));
//        finish();
//    }
    //adapter viewpager
    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment) {
            fragments.add(fragment);

        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }
}