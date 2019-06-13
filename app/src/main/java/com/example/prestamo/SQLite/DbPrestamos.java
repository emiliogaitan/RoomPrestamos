package com.example.prestamo.SQLite;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.prestamo.dao_clientes.Cliente_dao;
import com.example.prestamo.dao_clientes.PagoDao;
import com.example.prestamo.objeto_clientes_datos.Cliente;
import com.example.prestamo.dao_clientes.PrestamosDao;
import com.example.prestamo.objeto_clientes_datos.Pago;
import com.example.prestamo.objeto_clientes_datos.Prestamos;

@Database(version = 1, entities = {Prestamos.class, Cliente.class, Pago.class})
public abstract class DbPrestamos extends RoomDatabase {
    public static DbPrestamos INSTANCE;
    public abstract Cliente_dao clienteDao();
    public abstract PrestamosDao prestamosDao();
    public abstract PagoDao pagoDao();

    public static DbPrestamos getAppDatabase(Context context){
        if(INSTANCE == null)
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(), DbPrestamos.class, "db").allowMainThreadQueries().build();
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE=null;
    }
}
