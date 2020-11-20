package com.example.wri.Service;

public class APIService{
    private static final String BASE_URL = "http://192.168.20.157/wri/";

    public static DataService getService(){
        return APIRetrofitClient.getClient(BASE_URL).create(DataService.class);
    }
}

