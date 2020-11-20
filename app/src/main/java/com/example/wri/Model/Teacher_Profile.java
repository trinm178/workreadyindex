package com.example.wri.Model;

public class Teacher_Profile {
    private String teacherID;
    private String teacherName;
    private String teacherEmail;
    private String teacherPassword;
    private String teacherSpecialize;
    private String teacherPhoneNumber;
    private String typeUser;

    public Teacher_Profile() {
    }

    public Teacher_Profile(String teacherID, String teacherName, String teacherEmail, String teacherPassword, String teacherSpecialize, String teacherPhoneNumber, String typeUser) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.teacherPassword = teacherPassword;
        this.teacherSpecialize = teacherSpecialize;
        this.teacherPhoneNumber = teacherPhoneNumber;
        this.typeUser = typeUser;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherSpecialize() {
        return teacherSpecialize;
    }

    public void setTeacherSpecialize(String teacherSpecialize) {
        this.teacherSpecialize = teacherSpecialize;
    }

    public String getTeacherPhoneNumber() {
        return teacherPhoneNumber;
    }

    public void setTeacherPhoneNumber(String teacherPhoneNumber) {
        this.teacherPhoneNumber = teacherPhoneNumber;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }
}
