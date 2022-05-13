package com.example.llamada_telefonica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv1;
    ImageButton imb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.tv1);
        imb1=(ImageButton) findViewById(R.id.btn1);
        imb1.setOnClickListener(this);
    }

    public void onClick(View v) {
        tv1.setText("Llamando");
        Intent i = new Intent(android.content.Intent.ACTION_DIAL, Uri.parse("tel:937589750"));
        startActivity(i);

        Toast toast = Toast.makeText(this, "LLamando.....", Toast.LENGTH_SHORT);
        toast.show();
    }

}