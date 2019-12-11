package com.example.sysh.retrofit;

public class APIUtils implements Urls {

    private APIUtils(){}
    public static JsonApi getAlumnoService(){
        return RetrofitClient.getClient(URL).create(JsonApi.class);
    }
    public static JsonApi getAulaService(){
        return RetrofitClient.getClient(URL).create(JsonApi.class);
    }

}
