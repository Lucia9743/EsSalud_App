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
        findViewById(R.id.buttonn1s).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerta4();

            }
        });

    }

    private void Alerta4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Neurologia.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.alerta, null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();

        TextView txt = view.findViewById(R.id.textalert);
        txt.setText("¿Estas seguro que desea reservar una cita?");

        Button btnReintentar = view.findViewById(R.id.buttonb);
        btnReintentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Neurologia.this, "Cancelado", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        Button btnAceptar = view.findViewById(R.id.buttona);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Neurologia.this, Resumen_cita_neurologia.class);
                startActivity(intent);
            }
        });
    }
}