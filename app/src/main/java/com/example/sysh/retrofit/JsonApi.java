package com.example.sysh.retrofit;



import com.example.sysh.entity.Alumno;
import com.example.sysh.entity.Aula;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JsonApi {
    //Listar Alumnos
    @GET("listar")
    Call<List<Alumno>> getAlumnos();

    //Registrar Alumnos
    @POST("create")
    Call<Alumno> addAlumno(@Body Alumno alum);

    //Modificar Alumnos

    @PUT("update/{id}")
    Call<Alumno> updateAlumno(@Path("id") int id, @Body Alumno alum);

    //Eliminar Alumno
    @DELETE("delete/{id}")
    Call<Alumno> deleteAlumno(@Path("id") int id);

    //--AULA--//
    @GET("listar")
    Call<List<Aula>> getAula();
    @POST("create")
    Call<Aula> addAula(@Body Aula au);
    @PUT("update/{id}")
    Call<Aula> updateAula(@Path("id") int id, @Body Aula au);
    @DELETE("delete/{id}")
    Call<Aula> deleteAula(@Path("id") int id);
    //--AULA--//
}
