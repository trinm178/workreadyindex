package com.example.wri.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Companys {
    @SerializedName("isSuccess")
    @Expose
    private Integer isSuccess;
    @SerializedName("emailCompany")
    @Expose
    private String emailCompany;
    @SerializedName("message")
    @Expose
    private String message;

    public Companys() {
    }

    public Integer getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getEmailCompany() {
        return emailCompany;
    }

    public void setEmailCompany(String emailCompany) {
        this.emailCompany = emailCompany;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
