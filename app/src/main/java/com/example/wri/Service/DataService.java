package com.example.wri.Service;

import com.example.wri.Model.Classs;
import com.example.wri.Model.Companys;
import com.example.wri.Model.Students;
import com.example.wri.Model.Users;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {
    @FormUrlEncoded
    @POST("users/register_stu.php")
    Call<Students> createstudent(
            @Field("nameStudent") String nameStudent,
            @Field("emailStudent") String emailStudent,
            @Field("passwordStudent") String passwordStudent,
            @Field("phoneStudent") String phoneStudent,
            @Field("majorStudent") String majorStudent);
    @FormUrlEncoded
    @POST("users/register_co.php")
    Call<Companys> createcompany(
            @Field("nameCompany") String nameCompany,
            @Field("emailCompany") String emailCompany,
            @Field("passwordCompany") String passwordCompany,
            @Field("phoneCompany") String phoneCompany);
    @FormUrlEncoded
    @POST("users/login.php")
    Call<Users> login(
            @Field("email") String email,
            @Field("password") String password);
    //admin ......
    @GET("class/getall_class.php")
    Call<List<Classs>> getAllClass();
    @GET("admin/getall_student_admin.php")
    Call<List<Students>> getAllStudent_admin();
    @FormUrlEncoded
    @POST("admin/get_student.php")
    Call<List<Students>> getDetailStudent_admin(
            @Field("idstudent") String idstudent
    );

    //..........


}
