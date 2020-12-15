package com.example.essalud_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cita_medica extends AppCompatActivity {
    Button btnGene, btnEspeci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita_medica);
        getSupportActionBar().hide();

        btnGene = (Button)findViewById(R.id.btnMedGene);
        btnEspeci = (Button)findViewById(R.id.btnEspec);

        btnGene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMed = new Intent(Cita_medica.this, Medicina_general.class);
                startActivity(intentMed);
            }
        });
        btnEspeci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEspeci = new Intent(Cita_medica.this, Especialidades.class);
                startActivity(intentEspeci);

            }
        });


    }
}
