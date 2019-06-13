package com.example.prestamo.Entidades;

public class Entidade_Cliente {
    public static String tabla_usuario="Usuario";
    public static String nombre_campo="nombre";
    public static String apellido_campo="apellido";
    public static String sexo_campo="sexo";
    public static String telefono_campo="telefono";
    public static String cedula_campo="cedula";
    public static String ocupacion_campo="ocupacion";
    public static String direccion_campo="direccion";
    public static final String CREATE_TABLA_USUARIO="CREATE TABLE "+tabla_usuario+" ("+nombre_campo+" TEXT,"+apellido_campo +" TEXT,"+sexo_campo +" TEXT,"+telefono_campo+" TEXT,"+cedula_campo+" TEXT,"+ocupacion_campo+" TEXT,"+direccion_campo+" TEXT)";

}
