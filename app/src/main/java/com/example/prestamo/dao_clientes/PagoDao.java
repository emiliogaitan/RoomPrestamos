package com.example.prestamo.dao_clientes;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.example.prestamo.objeto_clientes_datos.Pago;

@Dao
public interface PagoDao {
    @Insert
    void Insertar(Pago pago);
}
