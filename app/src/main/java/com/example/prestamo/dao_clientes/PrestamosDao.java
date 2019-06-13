package com.example.prestamo.dao_clientes;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.prestamo.objeto_clientes_datos.Prestamos;
import com.example.prestamo.pojo_datos.Prestamo_Cliente;
import com.example.prestamo.pojo_datos.Prestamo_Cliente_Pagos;

import java.util.List;

@Dao
public interface PrestamosDao {
    @Insert
    void Insertar(Prestamos prestamos);

    @Query("select * from prestamos inner join cliente on cliente.cedula = prestamos.cedulaCliente")
    List<Prestamo_Cliente> MostrarPojo();

    @Query("select * from prestamos inner join cliente on cliente.cedula = prestamos.cedulaCliente where cedulaCliente=:cedula")
    List<Prestamo_Cliente> MostrarPojoCedula(String cedula);

    @Query("select * from cliente inner join prestamos on cliente.cedula = prestamos.cedulaCliente where prestamos.id=:id")
    Prestamo_Cliente_Pagos MostrarPojoTodo(int id);
}
