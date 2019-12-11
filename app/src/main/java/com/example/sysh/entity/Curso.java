package com.example.sysh.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Curso {
    @SerializedName("idcurso")
    @Expose
    private int idcurso;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("creditos")
    @Expose
    private int creditos;
    @SerializedName("horas_t")
    @Expose
    private int horas_t;
    @SerializedName("horas_p")
    @Expose
    private int horas_p;
    @SerializedName("prerequitos")
    @Expose
    private int prerequitos;
    @SerializedName("estado")
    @Expose
    private int estado;

    public Curso(int idcurso, String nombre, int creditos, int horas_t, int horas_p, int prerequitos, int estado) {
        this.idcurso = idcurso;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horas_t = horas_t;
        this.horas_p = horas_p;
        this.prerequitos = prerequitos;
        this.estado = estado;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHoras_t() {
        return horas_t;
    }

    public void setHoras_t(int horas_t) {
        this.horas_t = horas_t;
    }

    public int getHoras_p() {
        return horas_p;
    }

    public void setHoras_p(int horas_p) {
        this.horas_p = horas_p;
    }

    public int getPrerequitos() {
        return prerequitos;
    }

    public void setPrerequitos(int prerequitos) {
        this.prerequitos = prerequitos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
