package com.example.sysh.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("idusuario")
    @Expose
    private int idusuario;
    @SerializedName("idempleado")
    @Expose
    private int idempleado;
    @SerializedName("nomuser")
    @Expose
    private String nomuser;
    @SerializedName("clave")
    @Expose
    private String clave;

    public Usuario(int idusuario, int idempleado, String nomuser, String clave) {
        this.idusuario = idusuario;
        this.idempleado = idempleado;
        this.nomuser = nomuser;
        this.clave = clave;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getNomuser() {
        return nomuser;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
