package com.example.wri.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Classs implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("codeClass")
    @Expose
    private String codeClass;
    @SerializedName("nameClass")
    @Expose
    private String nameClass;
    @SerializedName("decriptionClass")
    @Expose
    private String decriptionClass;
    @SerializedName("maxStudentClass")
    @Expose
    private String maxStudentClass;
    @SerializedName("thumbnailClass")
    @Expose
    private String thumbnailClass;
    @SerializedName("currentStudentClass")
    @Expose
    private String currentStudentClass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(String codeClass) {
        this.codeClass = codeClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getDecriptionClass() {
        return decriptionClass;
    }

    public void setDecriptionClass(String decriptionClass) {
        this.decriptionClass = decriptionClass;
    }

    public String getMaxStudentClass() {
        return maxStudentClass;
    }

    public void setMaxStudentClass(String maxStudentClass) {
        this.maxStudentClass = maxStudentClass;
    }

    public String getThumbnailClass() {
        return thumbnailClass;
    }

    public void setThumbnailClass(String thumbnailClass) {
        this.thumbnailClass = thumbnailClass;
    }

    public String getCurrentStudentClass() {
        return currentStudentClass;
    }

    public void setCurrentStudentClass(String currentStudentClass) {
        this.currentStudentClass = currentStudentClass;
    }
}
