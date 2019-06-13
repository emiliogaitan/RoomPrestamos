package com.example.prestamo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.prestamo.SQLite.DbPrestamos;
import com.example.prestamo.objeto_clientes_datos.Cliente;


public class Lista_Clientes extends AppCompatActivity {
    private String indice="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cliente);
        Bundle extras =getIntent().getExtras();
        if(extras!=null){
            indice=extras.getString("indice");
            LlenarCliente();
        }
    }

    public void LlenarCliente(){
        TextView tvNombre = findViewById(R.id.etNombre);
        TextView tvApellido= findViewById(R.id.etApellido);
        TextView tvSexo= findViewById(R.id.spinner);
        TextView tvTelefono = findViewById(R.id.etTelefono);
        TextView tvCedula= findViewById(R.id.etCedula);
        TextView tvOcupacion= findViewById(R.id.etOcupacion);
        TextView tvDireccion= findViewById(R.id.etDireccion);

        Cliente cliente = DbPrestamos.getAppDatabase(this).clienteDao().MostrarClientePorId(indice);

        tvNombre.setText(cliente.getNombre());
        tvApellido.setText(cliente.getApelldio());
        tvSexo.setText(cliente.getSexo());
        tvTelefono.setText(cliente.getNumero());
        tvCedula.setText(cliente.getCedula());
        tvOcupacion.setText(cliente.getOcupacion());
        tvDireccion.setText(cliente.getDireccion());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnAgregar:
                Intent intent = new Intent(Lista_Clientes.this, SecondActivity.class);
                intent.putExtra("indice", indice);

                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
