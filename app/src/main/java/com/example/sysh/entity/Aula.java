package com.example.sysh.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Aula {

    @SerializedName("idaula")
    @Expose
    private int idaula;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("capacidad")
    @Expose
    private int capacidad;
    @SerializedName("tipo")
    @Expose
    private String tipo;

    public Aula(int idaula, String nombre, int capacidad, String tipo) {
        this.idaula = idaula;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
    }

    public int getIdaula() {
        return idaula;
    }

    public void setIdaula(int idaula) {
        this.idaula = idaula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
