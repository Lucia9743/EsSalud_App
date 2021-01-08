package com.example.essalud_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Especialidades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidades);
        getSupportActionBar().hide();

        Button btnNeuro = (Button)findViewById(R.id.idNeuro);
        btnNeuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Especialidades.this, Neurologia.class);
                startActivity(intent);
            }
        });

        Button btnPedi = (Button)findViewById(R.id.idPedi);
        btnPedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Especialidades.this, Pediatria.class);
                startActivity(intent);
            }
        });
    }
}
