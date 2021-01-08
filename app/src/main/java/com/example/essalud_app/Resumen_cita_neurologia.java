package com.example.essalud_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Resumen_cita_neurologia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_cita_neurologia);
        getSupportActionBar().hide();

        Button btnBack = (Button)findViewById(R.id.btnback2);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resumen_cita_neurologia.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}