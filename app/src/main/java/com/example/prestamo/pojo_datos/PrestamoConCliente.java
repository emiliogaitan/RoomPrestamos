package com.example.prestamo.pojo_datos;

import android.arch.persistence.room.Embedded;

import com.example.prestamo.objeto_clientes_datos.Cliente;
import com.example.prestamo.objeto_clientes_datos.Prestamos;

public class PrestamoConCliente {
    @Embedded
    Cliente cliente;

    @Embedded
    Prestamos prestamos;

    public PrestamoConCliente(){
        cliente=new Cliente();
        prestamos=new Prestamos();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Prestamos getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Prestamos prestamos) {
        this.prestamos = prestamos;
    }
}
