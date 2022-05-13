package com.example.ejercicio4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerMarca, spinnerTalla;
    private EditText txtCantidad;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        definirAtributos();
        accionCalcular();
    }

    private void definirAtributos(){
        spinnerMarca = (Spinner) findViewById(R.id.spinnerMarca);
        spinnerTalla = (Spinner) findViewById(R.id.spinnerTalla);
        txtCantidad = (EditText) findViewById(R.id.txtCantidad);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
    }

    private void accionCalcular(){
        btnCalcular.setOnClickListener((View v)->{
            String talla = String.valueOf(spinnerTalla.getSelectedItem());
            String marca = String.valueOf(spinnerMarca.getSelectedItem());
            Integer cantidad = Integer.parseInt(txtCantidad.getText().toString());

            Double precio = 0.0;
            Double descuento = 0.0;
            Double Total = 0.0;

            if(marca.equalsIgnoreCase("ADIDAS")){
                if(talla.equalsIgnoreCase("38-39")) precio = 200.0;
                else if(talla.equalsIgnoreCase("40-41")) precio = 245.0;
                else precio = 290.0;
                descuento = 0.1 * (precio * cantidad);
            }else if(marca.equalsIgnoreCase("NIKE")){
                if(talla.equalsIgnoreCase("38-39")) precio = 180.0;
                else if(talla.equalsIgnoreCase("40-41")) precio = 220.0;
                else precio = 250.0;
                descuento = 0.1 * (precio * cantidad);
            }else{
                if(talla.equalsIgnoreCase("38-39")) precio = 70.0;
                else if(talla.equalsIgnoreCase("40-41")) precio = 90.0;
                else precio = 115.0;
            }

            Total = (precio * cantidad) - descuento;

            AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
            alertbox.setMessage("Precio Inicial: "+ (precio * cantidad)+"\nDescuento: "+ descuento + "\nPrecio Final: " + Total);
            alertbox.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            alertbox.show();
        });




    }
}