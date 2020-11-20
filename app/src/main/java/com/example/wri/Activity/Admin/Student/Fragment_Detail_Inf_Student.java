package com.example.wri.Activity.Admin.Student;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.wri.Model.Students;
import com.example.wri.R;
import com.example.wri.Service.APIService;
import com.example.wri.Service.DataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Detail_Inf_Student  extends Fragment {
    Button btneditinf;
    TextView tv_name_student_detailadminf,tv_codestudent_detailstudentf,tv_birthday_student_detailadminf,
            tv_major_detailstudentf,tv_email_detailstudentf,tv_phone_detailstudentf;
    Students students;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_inf_detailstu_admin, container, false);
        Dataintent();
        Getdata(students.getId());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btneditinf = view.findViewById(R.id.btn_edit_detailstudentf);
        tv_name_student_detailadminf = view.findViewById(R.id.tv_name_student_detailadminf);
        tv_codestudent_detailstudentf = view.findViewById(R.id.tv_codestudent_detailstudentf);
        tv_birthday_student_detailadminf = view.findViewById(R.id.tv_birthday_student_detailadminf);
        tv_major_detailstudentf = view.findViewById(R.id.tv_major_detailstudentf);
        tv_email_detailstudentf = view.findViewById(R.id.tv_email_detailstudentf);
        tv_phone_detailstudentf = view.findViewById(R.id.tv_phone_detailstudentf);
        btneditinf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Dialogeditinf();
            }
        });
        //


    }
    private void Getdata(String email) {
        DataService dataService = APIService.getService();
        Call<List<Students>> callback = dataService.getDetailStudent_admin(email);
        callback.enqueue(new Callback<List<Students>>() {
            @Override
            public void onResponse(Call<List<Students>> call, Response<List<Students>> response) {
                tv_name_student_detailadminf.setText(students.getNameStudent());
                tv_codestudent_detailstudentf.setText(students.getCodeStudent());
                tv_birthday_student_detailadminf.setText(students.getBirthdayStudent());
                tv_major_detailstudentf.setText(students.getMajor());
                tv_email_detailstudentf.setText(students.getEmailUser());
                tv_phone_detailstudentf.setText(students.getPhoneUser());
            }

            @Override
            public void onFailure(Call<List<Students>> call, Throwable t) {

            }
        });
    }
    private void Dataintent() {
        Intent intent = getActivity().getIntent();
        if(intent != null){
            if(intent.hasExtra("student_admin")) {
                students = (Students) intent.getSerializableExtra("student_admin");
            }
        }

    }
    private void Dialogeditinf(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dialog);

        dialog.show();
    }
}
