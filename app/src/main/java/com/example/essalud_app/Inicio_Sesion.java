package com.example.essalud_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Inicio_Sesion extends AppCompatActivity {
    EditText edtDNIusu, edtPASSusu;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio__sesion);
        getSupportActionBar().hide();

        edtDNIusu = (EditText)findViewById(R.id.edtDnifill);
        edtPASSusu = (EditText)findViewById(R.id.edtPassFill);
        btnLogin = (Button)findViewById(R.id.btnSesionIni);

        Button btnIniSesion = (Button)findViewById(R.id.btnSesionIni);
        btnIniSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtDNIusu.getText().toString().isEmpty() && edtPASSusu.getText().toString().isEmpty())
                {
                    edtDNIusu.setError("Campo Incompleto");
                    edtPASSusu.setError("Campo Incompleto");
                    return;
                }
                if (edtDNIusu.getText().toString().isEmpty()){
                    edtDNIusu.setError("Campo Incompleto");
                    return;
                }
                if(edtPASSusu.getText().toString().isEmpty()){
                    edtPASSusu.setError("Campo Incompleto");
                    return;
                }

                login();
            }
        });


    }
    public Connection conexionBD(){
        Connection conexion = null;
        try{
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.3;databaseName=essaludDBs;user=test;password=test");
            //192.168.0.2
            //Toast.makeText(getApplicationContext(), "conexion satisfactoria",Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT).show();

        }
        return conexion;

    }
    public void login(){
        try{
           Statement st = conexionBD().createStatement();
           ResultSet rs = st.executeQuery("select * from usuariosCreados where DNI_Usuario =" + edtDNIusu.getText().toString() + "and Contrasena_usuario = '" + edtPASSusu.getText().toString() + "'");
           if (rs.next()){
               Toast.makeText(getApplicationContext(),"Bienvenido!",Toast.LENGTH_LONG).show();
               Intent intent = new Intent(Inicio_Sesion.this, Menu.class);
               intent.putExtra("keydni",edtDNIusu.getText().toString());
               startActivity(intent);
           }
           else{
               Toast.makeText(getApplicationContext(),"DNI no existe",Toast.LENGTH_LONG).show();
           }

        }catch (SQLException e)
        {
            Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }
}
