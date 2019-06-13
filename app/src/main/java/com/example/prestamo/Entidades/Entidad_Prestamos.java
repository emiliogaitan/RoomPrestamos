package com.example.prestamo.Entidades;

public class Entidad_Prestamos {
    public static String tabla_usuario="prestamos";
    public static String nombre_completo_campo="nombrecompleto";
    public static String monto_campo="monto";
    public static String interes_campo="interes";
    public static String plazo_campo="plazo";
    public static String fecha_inicial_campo="FechaInicial";
    public static String fecha_final_campo="FechaFinal";
    public static String monto_total_campo="MontoTotal";
    public static String monto_cuotas_campo="MontoCuotas";
    public static final String CREATE_TABLA_USUARIO="CREATE TABLE "+tabla_usuario+" ("+nombre_completo_campo+" TEXT,"+monto_campo +" TEXT,"+interes_campo +
            " TEXT,"+plazo_campo+" TEXT,"+fecha_inicial_campo+" TEXT,"+fecha_final_campo+" TEXT,"+monto_total_campo+" TEXT,"+monto_cuotas_campo +" TEXT)";

}
