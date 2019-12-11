package com.example.sysh.retrofit;



import com.example.sysh.entity.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface ApiUsuario {
    @POST("login")
    Call<Usuario> validarUsuario(@Body Usuario user
    );

}
