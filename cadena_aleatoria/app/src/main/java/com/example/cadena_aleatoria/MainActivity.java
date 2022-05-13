package com.example.cadena_aleatoria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.widget.Toast.*;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    private String numbers = "0123456789";
    private String simbolos ="!#$%&@";
    private Button btnGenerar;
    private TextView txtCodigo;
    private String alphaNumeric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGenerar = (Button)findViewById(R.id.btnGenerar);
        txtCodigo = (TextView)findViewById(R.id.txtCodigo);
        alphaNumeric = upperAlphabet + lowerAlphabet + numbers+simbolos;
        generarCodigo();
    }

    private void generarCodigo(){
        btnGenerar.setOnClickListener((View v)->{
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            char randomChar;
            for(int i = 0; i < 10; i++) {
                int index = random.nextInt(71);
                randomChar = alphaNumeric.charAt(index);
                sb.append(randomChar);
            }
            String randomString = sb.toString();
            txtCodigo.setText(randomString);
        });
    }
}