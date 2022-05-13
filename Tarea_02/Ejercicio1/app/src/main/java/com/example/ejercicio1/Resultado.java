package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Resultado extends AppCompatActivity {

    private ImageView imgLugar;
    private TextView mostrarResultados[];
    private Button btnRetornar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        definirAtributos();
        eventoInicio();
        eventoBtnRetornar();
    }

    private void definirAtributos(){
        imgLugar = (ImageView) findViewById(R.id.imgLugar);
        mostrarResultados = new TextView[4];
        mostrarResultados[0] = (TextView) findViewById(R.id.tvCostoDia);
        mostrarResultados[1] = (TextView) findViewById(R.id.tvCostoTotal);
        mostrarResultados[2] = (TextView) findViewById(R.id.tvDescuento);
        mostrarResultados[3] = (TextView) findViewById(R.id.tvTotalPagar);
        btnRetornar = (Button) findViewById(R.id.btnRetornar);
    }

    private void eventoInicio(){
        Double valores[] = calcularDatos();
        for(int i = 0; i<mostrarResultados.length; i++){
            mostrarResultados[i].setText(mostrarResultados[i].getText().toString() + valores[i]);
        }

    }

    private void eventoBtnRetornar(){
        btnRetornar.setOnClickListener((View v)->{
            Intent intent = new Intent(this, MainActivity.class);
            finish();
        });
    }

    private Double[] calcularDatos(){
        Bundle datos = getIntent().getExtras();
        String lugar = datos.getString("lugar");
        Integer cantidadPersonas = datos.getInt("personas");
        Integer cantidadDias = datos.getInt("dias");
        Double valores[] = {0.0, 0.0, 0.0, 0.0};
        switch(lugar) {
            case "Arequipa":
                imgLugar.setImageResource(R.drawable.arequipa);
                valores[0] = 130.0;
                break;
            case "Cuzco":
                imgLugar.setImageResource(R.drawable.curzo);
                valores[0] = 150.0;
                break;
            case "Tumbes":
                imgLugar.setImageResource(R.drawable.tumbes);
                valores[0] = 100.0;
                break;
            case "Cajamarca":
                imgLugar.setImageResource(R.drawable.cajamarca);
                valores[0] = 110.0;
                break;
        }
        valores[1] = valores[0] * cantidadDias;
        if(cantidadPersonas > 4) valores[2] = 0.15 * valores[1];
        valores[3] = valores[1] - valores[2];
        return valores;
    }
}