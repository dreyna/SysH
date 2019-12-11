package com.example.sysh.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Horario {

    @SerializedName("idhorario")
    @Expose
    private int idhorario;
    @SerializedName("idusuario")
    @Expose
    private int idusuario;
    @SerializedName("idescuela")
    @Expose
    private int idescuela;
    @SerializedName("idcurso")
    @Expose
    private int idcurso;
    @SerializedName("idaula")
    @Expose
    private int idaula;
    @SerializedName("dias")
    @Expose
    private String dias;
    @SerializedName("hora_inicio")
    @Expose
    private String hora_inicio;
    @SerializedName("hora_fin")
    @Expose
    private String hora_fin;
    @SerializedName("turno")
    @Expose
    private String turno;
    @SerializedName("semestre")
    @Expose
    private String semestre;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("ciclo")
    @Expose
    private String ciclo;
    @SerializedName("estado")
    @Expose
    private String estado;

    public Horario(int idhorario, int idusuario, int idescuela, int idcurso, int idaula, String dias, String hora_inicio, String hora_fin, String turno, String semestre, String year, String ciclo, String estado) {
        this.idhorario = idhorario;
        this.idusuario = idusuario;
        this.idescuela = idescuela;
        this.idcurso = idcurso;
        this.idaula = idaula;
        this.dias = dias;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.turno = turno;
        this.semestre = semestre;
        this.year = year;
        this.ciclo = ciclo;
        this.estado = estado;
    }

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdescuela() {
        return idescuela;
    }

    public void setIdescuela(int idescuela) {
        this.idescuela = idescuela;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getIdaula() {
        return idaula;
    }

    public void setIdaula(int idaula) {
        this.idaula = idaula;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
