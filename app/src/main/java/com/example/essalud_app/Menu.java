package com.example.essalud_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    ImageButton btnCita;
    String dniLogin, dniRegis;
    TextView txtDniView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();

        txtDniView = (TextView)findViewById(R.id.txtdni);

        dniLogin = getIntent().getExtras().getString("keydni"); //Login DNI
        dniRegis =  getIntent().getExtras().getString("keydniregis"); //Registro DNI


        if (dniLogin.isEmpty()){
            txtDniView.setText(dniRegis);
        }
        else{
            txtDniView.setText(dniLogin);
        }

        btnCita = (ImageButton)findViewById(R.id.btnCitaMed);
        btnCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Cita_medica.class);
                startActivity(intent);
            }
        });




    }
}
