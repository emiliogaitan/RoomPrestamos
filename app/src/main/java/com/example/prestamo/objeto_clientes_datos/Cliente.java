package com.example.prestamo.objeto_clientes_datos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Cliente {
    private String nombre;
    private String apelldio;
    private String sexo;
    private String numero;
    @PrimaryKey() @NonNull
    private String cedula;
    private String ocupacion;
    private String direccion;

    public Cliente() {
    }

    public Cliente(String nombre, String apelldio, String sexo, String numero, String cedula, String ocupacion, String direccion) {
        this.nombre = nombre;
        this.apelldio = apelldio;
        this.sexo = sexo;
        this.numero = numero;
        this.cedula = cedula;
        this.ocupacion = ocupacion;
        this.direccion = direccion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelldio() {
        return apelldio;
    }

    public void setApelldio(String apelldio) {
        this.apelldio = apelldio;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
