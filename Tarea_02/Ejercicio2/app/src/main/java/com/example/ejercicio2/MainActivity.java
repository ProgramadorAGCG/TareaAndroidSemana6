package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView txtResultado;
    private EditText txtLado1, txtLado2, txtLado3;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarAtributos();
        btnCalcular();
    }

    private void iniciarAtributos(){
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        txtLado1 = (EditText) findViewById(R.id.txtLado1);
        txtLado2 = (EditText) findViewById(R.id.txtLado2);
        txtLado3 = (EditText) findViewById(R.id.txtLado3);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
    }

    private void btnCalcular(){
        DecimalFormat formato = new DecimalFormat("#.00");
        btnCalcular.setOnClickListener((View v)->{
            Double lado1 = Double.parseDouble(txtLado1.getText().toString());
            Double lado2 = Double.parseDouble(txtLado2.getText().toString());
            Double lado3 = Double.parseDouble(txtLado3.getText().toString());
            Double perimetro = lado1 + lado2 + lado3;
            Double semiperimetro = perimetro/2;
            Double area = Math.sqrt((semiperimetro * (semiperimetro - lado1) * (semiperimetro - lado2) * (semiperimetro - lado3)));
            txtResultado.setText("El área del triangulo es " + formato.format(area));
        });
    }
}