package com.example.prestamo;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteConstraintException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prestamo.adapters.AdapPago;
import com.example.prestamo.SQLite.DbPrestamos;
import com.example.prestamo.objeto_clientes_datos.Pago;
import com.example.prestamo.pojo_datos.Prestamo_Cliente_Pagos;


public class VerPrestamosActivity extends AppCompatActivity {
    private int id=0;
    private Prestamo_Cliente_Pagos prestamoClientePagos =new Prestamo_Cliente_Pagos();
    private AdapPago adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_prestamos);

        Bundle extras =getIntent().getExtras();
        ListView lvPagos = findViewById(R.id.lvPagos);
        if(extras!=null){
            id=extras.getInt("id");
            prestamoClientePagos =DbPrestamos.getAppDatabase(this).prestamosDao().MostrarPojoTodo(id);
            llenarPrestamo();
            adapter= new AdapPago(this, R.layout.item_pago, prestamoClientePagos.getPagoList());
            lvPagos.setAdapter(adapter);

        }
    }

    public void llenarPrestamo(){
        TextView tvNombreCliente = findViewById(R.id.spUsuarios);
        TextView tvMontoCredito= findViewById(R.id.etMontoCredito);
        TextView tvInteres= findViewById(R.id.spInteres);
        TextView tvPlazo= findViewById(R.id.etPlazo);
        TextView tvFecha= findViewById(R.id.etFecha);
        TextView tvFechaFinal= findViewById(R.id.etFechaFinal);
        TextView tvMontoPagar= findViewById(R.id.tvMontoPagar);
        TextView tvMontoCuota= findViewById(R.id.tvMontoPagado);

        if(prestamoClientePagos.getPagoList().size()==0)
            tvMontoCuota.setText("0.00");
        else{
            float total=0;
            for (int i = 0; i< prestamoClientePagos.getPagoList().size(); i++){
                total+= prestamoClientePagos.getPagoList().get(i).getMonto();
            }
            tvMontoCuota.setText(String.valueOf(total));
        }
        tvMontoPagar.setText(prestamoClientePagos.getPrestamos().getMontoPagar().toString());
        tvFechaFinal.setText(prestamoClientePagos.getPrestamos().getFechaFinal());
        tvFecha.setText(prestamoClientePagos.getPrestamos().getFechaInicio());
        tvPlazo.setText(String.valueOf(prestamoClientePagos.getPrestamos().getPlazo()));
        tvInteres.setText(prestamoClientePagos.getPrestamos().getInteres());
        tvMontoCredito.setText(prestamoClientePagos.getPrestamos().getMonto().toString());
        tvNombreCliente.setText(prestamoClientePagos.getCliente().getNombre() + " "+ prestamoClientePagos.getCliente().getApelldio());
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
                TextView montoPagado= findViewById(R.id.tvMontoPagado);
                final TextView montoApagar = findViewById(R.id.tvMontoPagar);
                if(Float.parseFloat(montoApagar.getText().toString())>Float.parseFloat(montoPagado.getText().toString())){

                    AlertDialog.Builder builder = new AlertDialog.Builder(VerPrestamosActivity.this);
                    builder.setTitle("Monto Pago");
                    final View view = LayoutInflater.from(VerPrestamosActivity.this).inflate(R.layout.dialog_pago, null, false);
                    builder.setView(view);
                    builder.setNegativeButton("Cancelar", null);
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText etCantidad= view.findViewById(R.id.etCantidad);

                        Pago pago= new Pago();
                        if(calcular()+Float.parseFloat(etCantidad.getText().toString()) >Float.parseFloat(montoApagar.getText().toString())){
                            pago.setMonto(Float.parseFloat(etCantidad.getText().toString())-((calcular()+Float.parseFloat(etCantidad.getText().toString()))- Float.parseFloat(montoApagar.getText().toString())));
                        }else{
                            pago.setMonto(Float.parseFloat(etCantidad.getText().toString()));
                        }
                        pago.setIdPrestamo(prestamoClientePagos.getPrestamos().getId());
                        try {
                            DbPrestamos.getAppDatabase(VerPrestamosActivity.this).pagoDao().Insertar(pago);
                            prestamoClientePagos.getPagoList().add(pago);
                            adapter.notifyDataSetChanged();
                            calcularPago();
                        }catch (SQLiteConstraintException e){
                            Toast.makeText(VerPrestamosActivity.this, "Error Activity", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                }else{
                    Toast.makeText(this, "Exito Pago", Toast.LENGTH_SHORT).show();
                }

        }
        return super.onOptionsItemSelected(item);
    }

    public void calcularPago(){
        TextView tvMontoCuota = findViewById(R.id.tvMontoPagado);
        if(prestamoClientePagos.getPagoList().size()==0)
            tvMontoCuota.setText("0.00");
        else{
            float total=0;
            for (int i = 0; i< prestamoClientePagos.getPagoList().size(); i++){
                total+= prestamoClientePagos.getPagoList().get(i).getMonto();
            }
            tvMontoCuota.setText(String.valueOf(total));
        }
    }

    public float calcular(){
        TextView tvMontoCuota = findViewById(R.id.tvMontoPagado);
        float total=0;
        if(prestamoClientePagos.getPagoList().size()==0) {
            tvMontoCuota.setText("0.00");
        }
        else{
            for (int i = 0; i< prestamoClientePagos.getPagoList().size(); i++){
                total+= prestamoClientePagos.getPagoList().get(i).getMonto();
            }

        }
        return total;
    }
}
