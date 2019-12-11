package com.example.sysh.retrofit;

import com.example.sysh.entity.Aula;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiAula {
    @GET("listar")
    Call<List<Aula>> getAula();
    @POST("create")
    Call<Aula> addAula(@Body Aula au);
    @PUT("update/{id}")
    Call<Aula> updateAula(@Path("id") int id, @Body Aula au);
    @DELETE("delete/{id}")
    Call<Aula> deleteAula(@Path("id") int id);
}
