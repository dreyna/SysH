package com.example.sysh.retrofit;



import com.example.sysh.entity.Usuario;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiUsuario {
    @POST("user")
    Call<Usuario> validarUsuario(@Body Usuario user);
}
