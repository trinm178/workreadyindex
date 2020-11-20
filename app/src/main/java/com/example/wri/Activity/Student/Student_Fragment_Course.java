package com.example.wri.Activity.Student;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wri.R;


public class Student_Fragment_Course extends Fragment {

    Button btnShowDetail;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student___course, container, false);
        btnShowDetail = view.findViewById(R.id.btn_showdetail);
        btnShowDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogShowDetail();
            }
        });
        return view;
    }
    private void DialogShowDetail(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.customdialog_showdetail_course);
        final Button btnShowDetail = dialog.findViewById(R.id.btn_showdetail);
        dialog.show();
    }
}