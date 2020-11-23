package com.example.wri.Activity.Admin.Student;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;
import com.example.wri.Model.Students;
import com.example.wri.R;
import com.example.wri.Service.APIService;
import com.example.wri.Service.DataService;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Detail_Inf_Student  extends Fragment {
    Button btneditinf;
    TextView tv_name_student_detailadminf,tv_codestudent_detailstudentf,tv_birthday_student_detailadminf,
            tv_major_detailstudentf,tv_email_detailstudentf,tv_phone_detailstudentf;
    Students students;
    private ImageButton ibPick;
    private CircleImageView civProfile;
    private ProgressDialog progressDialog;
    private String url = "http://192.168.1.113/wri/admin/update_inf_student_admin.php";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_inf_detailstu_admin, container, false);
        Dataintent();
        Getdata(students.getId());
        progressDialog = new ProgressDialog(getActivity().getApplicationContext());
        progressDialog.setMessage("Uploading Image. Please wait");
        progressDialog.setCancelable(false);
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
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
        ibPick = view.findViewById(R.id.profile_image_student_admincreate);
        civProfile =view.findViewById(R.id.img_edit_student_admin);
        ibPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(getActivity())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                CropImage.activity()
                                        .setGuidelines(CropImageView.Guidelines.ON)
                                        .start(getActivity());
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {
                                if(response.isPermanentlyDenied()){
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setTitle("Permisstion Required")
                                            .setMessage("Permisstion to assecc your device storage  is required to pick profile image. Please go to setting to enable permisstion to access")
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    Intent intent = new Intent();
                                                    intent.setAction(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                                                    intent.setData(Uri.fromParts("package",getActivity().getApplicationContext().getPackageName(),null));
                                                    startActivityForResult(intent, 51);

                                                }
                                            })
                                            .setNegativeButton("Cancel",null)
                                            .show();
                                }
                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });


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
                Picasso.with(getActivity().getApplicationContext()).load(students.getThumbnailStudent()).into(civProfile);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == getActivity().RESULT_OK) {
                final Uri resultUri = result.getUri();
                civProfile.setImageURI(resultUri);
                btneditinf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("nn","1");
                        final String nameStudent = tv_name_student_detailadminf.getText().toString();
                        final String codeStudent = tv_codestudent_detailstudentf.getText().toString();
                        final String birthdayStudent = tv_birthday_student_detailadminf.getText().toString();
                        final String major = tv_major_detailstudentf.getText().toString();
                        final String emailUser = tv_email_detailstudentf.getText().toString();
                        final String phoneUser = tv_phone_detailstudentf.getText().toString();
                        File imageFile = new File (resultUri.getPath());
                        progressDialog.show();
                        AndroidNetworking.upload(url)
                                .addMultipartFile("image",imageFile)
                                .addMultipartParameter("nameStudent",nameStudent)
                                .addMultipartParameter("codeStudent",codeStudent)
                                .addMultipartParameter("birthdayStudent",birthdayStudent)
                                .addMultipartParameter("major",major)
                                .addMultipartParameter("emailUser",emailUser)
                                .addMultipartParameter("phoneUser",phoneUser)
                                .setPriority(Priority.HIGH)
                                .build()
                                .setUploadProgressListener(new UploadProgressListener() {
                                    @Override
                                    public void onProgress(long bytesUploaded, long totalBytes) {
                                        float progress = (float) bytesUploaded/totalBytes*100;
                                        progressDialog.setProgress((int)progress);
                                    }
                                })
                                .getAsString(new StringRequestListener() {
                                    @Override
                                    public void onResponse(String response) {
                                        try {
                                            Log.d("nnn",response);
                                            progressDialog.dismiss();
                                            JSONObject jsonObject = new JSONObject(response);
                                            int status = jsonObject.getInt("status");
                                            String message = jsonObject.getString("message");
                                            if(status == 0){
                                                Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                                            }
                                        } catch (JSONException e) {
                                            Toast.makeText(getActivity().getApplicationContext(), "Pasring Error", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onError(ANError anError) {
                                        progressDialog.dismiss();
                                        anError.printStackTrace();
                                        Toast.makeText(getActivity().getApplicationContext(), "Tạo lớp không thành công", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}
