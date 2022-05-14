package com.example.sem06_app_permisos_reproducir_yotutube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.EditText; //para usar cuadros de texto
import android.widget.Button; //para usar botones
import android.widget.Toast; //para mostrar mensajes "emergentes"
import android.content.Intent;
import android.net.Uri; //para llamar a un número de teléfono
import android.app.AlertDialog; //para mostrar mensaje de confirmación
import android.content.DialogInterface;
public class MainActivity extends AppCompatActivity {
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.btn1);
        btn1.setOnClickListener (new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_DIAL, Uri.parse("tel:015937007"));
                startActivity(i);
            }
        });
    }

    public void onClickWebBrowser(View view) {
    }
}