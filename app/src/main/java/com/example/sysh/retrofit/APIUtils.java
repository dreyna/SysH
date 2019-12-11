package com.example.sysh.retrofit;

public class APIUtils implements Urls {

    private APIUtils(){}
    public static ApiAlumno getAlumnoService(){
        return RetrofitClient.getClient(URL).create(ApiAlumno.class);
    }
    public static ApiAula getAulaService(){
        return RetrofitClient.getClient(URL_AULA).create(ApiAula.class);
    }
    public static ApiUsuario getusuarioService(){
        return RetrofitClient.getClient(URL_USUARIO).create(ApiUsuario.class);
    }

}
