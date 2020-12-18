package com.example.essalud_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Medicina_general extends AppCompatActivity {

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
                Alerta();

            }
        });



    }

    private void Alerta(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Medicina_general.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.alerta, null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();

        TextView txt = view.findViewById(R.id.textalert);
        txt.setText("¿Estas segur que desea reservar una cita?");

        Button btnReintentar = view.findViewById(R.id.buttonb);
        btnReintentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Medicina_general.this, "Conectando", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
}
