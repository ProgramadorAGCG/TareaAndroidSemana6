package com.example.ejercicio1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAceptar;
    private RadioButton opciones[];
    private EditText txtNumPersonas;
    private EditText txtCantidadDias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        definirAtributos();
        accionBtnAceptar();
    }

    private void definirAtributos(){
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        opciones = new RadioButton[4];
        opciones[0] = (RadioButton) findViewById(R.id.rbtnArequipa);
        opciones[1] = (RadioButton) findViewById(R.id.rbtnCuzco);
        opciones[2] = (RadioButton) findViewById(R.id.rbtnTumbes);
        opciones[3] = (RadioButton) findViewById(R.id.rbtnCajamarca);
        txtNumPersonas = (EditText) findViewById(R.id.txtNumPersonas);
        txtCantidadDias = (EditText) findViewById(R.id.txtCantidadDias);
    }

    private String comprobarCheckRadio(){
        for(RadioButton valor : opciones){
            if(valor.isChecked()) return valor.getText().toString();
        }
        return "";
    }

    private void crearAlerta(String cadena){
        AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
        alertbox.setMessage(cadena);
        alertbox.setPositiveButton("Si", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        alertbox.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        alertbox.show();
    }

    private void accionBtnAceptar(){
        btnAceptar.setOnClickListener((View v)->{
            if(comprobarCheckRadio().equals("")){
                crearAlerta("No se ha seleccionado ningun lugar");
            }else if(!txtNumPersonas.getText().toString().matches("[+-]?\\d*(\\.\\d+)?") || txtNumPersonas.getText().toString().replace(" ","").equals("")){
                crearAlerta("Debes ingresar un valor numérico en el campo cantidad de personas");
            }else if(!txtCantidadDias.getText().toString().matches("[+-]?\\d*(\\.\\d+)?") || txtCantidadDias.getText().toString().replace(" ","").equals("")){
                crearAlerta("Debes ingresar un valor numérico en el campo cantidad de días");
            }else{
                String lugar = comprobarCheckRadio();
                Integer numeroPersonas = Integer.parseInt(txtNumPersonas.getText().toString());
                Integer numeroDias = Integer.parseInt(txtCantidadDias.getText().toString());
                Intent intent = new Intent(this, Resultado.class);
                intent.putExtra("lugar",lugar);
                intent.putExtra("personas",numeroPersonas);
                intent.putExtra("dias",numeroDias);
                startActivity(intent);
                finish();
            }
        });
    }

}