package com.example.ejercicio3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnIniciarJuego, btnAceptar;
    private EditText txtNumero;
    private ImageView imgAorcado;
    private TextView tvMensaje;
    private Integer numeroRandom;
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        definirAtributos();
        accionIniciarJuego();
        accionAceptar();
    }

    private void visibilidad(int valor){
        btnAceptar.setVisibility(valor);
        txtNumero.setVisibility(valor);
        imgAorcado.setVisibility(valor);
        tvMensaje.setVisibility(valor);
    }

    private void definirAtributos(){
        btnIniciarJuego = (Button) findViewById(R.id.btnIniciarJuego);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        txtNumero = (EditText) findViewById(R.id.txtNumero);
        imgAorcado = (ImageView) findViewById(R.id.imgAorcado);
        tvMensaje = (TextView) findViewById(R.id.tvMensaje);
    }

    private void accionIniciarJuego(){
        btnIniciarJuego.setOnClickListener((View v)->{
            visibilidad(View.VISIBLE);
            numeroRandom = (int) (Math.random() * 66);
            btnIniciarJuego.setText("Reiniciar Juego");
            contador=0;
            definirImagen();
            txtNumero.setText("");
        });
    }

    private void alerta(String cadena){
        AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
        alertbox.setMessage(cadena);
        alertbox.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        alertbox.show();
    }

    private void accionAceptar(){
        btnAceptar.setOnClickListener((View v)->{
            Integer valor = Integer.parseInt(txtNumero.getText().toString());
            if(valor == numeroRandom){
                alerta("Excelente, has ganado");
                visibilidad(View.INVISIBLE);
                btnIniciarJuego.setText("INICIAR JUEGO");
            }else{
                contador++;
                if(contador == 6){
                    alerta("Han finalizado tus intentos, el número era "+numeroRandom);
                    visibilidad(View.INVISIBLE);
                    btnIniciarJuego.setText("INICIAR JUEGO");
                }else {
                    if (valor > numeroRandom) alerta("El numero debe ser menor");
                    else alerta("El numero debe ser mayor");
                }
            }
            definirImagen();
        });
    }

    private void definirImagen(){
        switch (contador) {
            case 0: imgAorcado.setImageResource(R.drawable.android);break;
            case 1: imgAorcado.setImageResource(R.drawable.paso_1);break;
            case 2: imgAorcado.setImageResource(R.drawable.paso_2);break;
            case 3: imgAorcado.setImageResource(R.drawable.paso_3);break;
            case 4: imgAorcado.setImageResource(R.drawable.paso_4);break;
            case 5: imgAorcado.setImageResource(R.drawable.paso_5);break;
            case 6: imgAorcado.setImageResource(R.drawable.paso_6);break;
        }
    }


}