package com.example.essalud_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio_Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio__registro);
        getSupportActionBar().hide();

        Button btnRegistrarse = (Button) findViewById(R.id.btnRegis);
        Button btnIniSesion = (Button)findViewById(R.id.btnIniSesi);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Inicio_Registro.this, Registro_Usuario.class);
                startActivity(intent1);
            }
        });

        btnIniSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Inicio_Registro.this, Inicio_Sesion.class);
                startActivity(intent2);
            }
        });
    }
}
