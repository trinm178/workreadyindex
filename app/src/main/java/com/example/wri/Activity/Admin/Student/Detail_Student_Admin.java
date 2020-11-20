package com.example.wri.Activity.Admin.Student;

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
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wri.Activity.Company.Company_Detail_Student;
import com.example.wri.Model.Students;
import com.example.wri.R;
import com.example.wri.Service.APIService;
import com.example.wri.Service.DataService;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail_Student_Admin extends AppCompatActivity {
     Students students;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView tvnameStudent;
    private Fragment_Detail_Inf_Student inf_student;
    private Fragment_Detail_Point_Student point_student;
    ImageView img_student_detailadmin;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__student__admin);
         students = new Students();
         init();
         Dataintent();
         Getdata(students.getId());

         //setcolor text hover and non click
         tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#2c5ca4"));
         tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
         tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#2c5ca4"));
         //
         tabLayout.setupWithViewPager(viewPager);
         ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),0);
         viewPagerAdapter.addFragment(point_student,"Bảng điểm");
         viewPagerAdapter.addFragment(inf_student,"Thông tin cá nhân");
         viewPager.setAdapter(viewPagerAdapter);
    }

    private void init() {
        viewPager = findViewById(R.id.view_pager_detailstudent_admin);
        tabLayout = findViewById(R.id.tab_layout_detailstudent_admin);
        tvnameStudent = findViewById(R.id.tv_name_student_detailadmin);
        img_student_detailadmin = findViewById(R.id.img_student_detailadmin);
        inf_student = new Fragment_Detail_Inf_Student();
        point_student = new Fragment_Detail_Point_Student();
    }

    private void Getdata(String email) {
          DataService dataService = APIService.getService();
//        tvnameStudent.setText(students.getNameStudent());
//        Picasso.with(Detail_Student_Admin.this).load(students.getThumbnailStudent()).into(img_student_detailadmin);
          Call<List<Students>> callback = dataService.getDetailStudent_admin(email);
          callback.enqueue(new Callback<List<Students>>() {
              @Override
              public void onResponse(Call<List<Students>> call, Response<List<Students>> response) {
                  tvnameStudent.setText(students.getNameStudent());
                  Picasso.with(Detail_Student_Admin.this).load(students.getThumbnailStudent()).into(img_student_detailadmin);
              }

              @Override
              public void onFailure(Call<List<Students>> call, Throwable t) {
                 Log.d("nnn","thất bại");
              }
          });
     }

    private void Dataintent() {
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("student_admin")) {
                students = (Students) intent.getSerializableExtra("student_admin");
            }
        }

    }
    //adapter viewpager
    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragmentTitle.add(title);
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