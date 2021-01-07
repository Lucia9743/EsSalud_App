package com.example.essalud_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Medicina_general extends AppCompatActivity {
    EditText txtNombre, txtApellido, txtHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicina_general);
        getSupportActionBar().hide();


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerta();

            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerta1();

            }
        });


    }

    private void Alerta() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Medicina_general.this);
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
                Toast.makeText(Medicina_general.this, "Cancelado", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        Button btnAceptar = view.findViewById(R.id.buttona);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Medicina_general.this, Resumen_cita.class);
                startActivity(intent);
            }
        });


    }

    private void Alerta1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Medicina_general.this);
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
                Toast.makeText(Medicina_general.this, "Jajaja", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
}




