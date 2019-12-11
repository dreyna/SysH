package com.example.sysh.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Escuela {
    @SerializedName("idescuela")
    @Expose
    private int idescuela;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    public Escuela(int idescuela, String nombre) {
        this.idescuela = idescuela;
        this.nombre = nombre;
    }

    public int getIdescuela() {
        return idescuela;
    }

    public void setIdescuela(int idescuela) {
        this.idescuela = idescuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
