package com.example.essalud_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Neurologia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neurologia);
        getSupportActionBar().hide();


        findViewById(R.id.buttonns).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerta4();

            }
        });

    }


        Button btnAceptar = view.findViewById(R.id.buttona);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Neurologia.this, Resumen_cita.class);
                startActivity(intent);
            }
        });
    }
}