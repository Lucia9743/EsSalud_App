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

public class Registro_Usuario extends AppCompatActivity {

    EditText edtDNIVali, edtContra, edtReContra;
    Button btnRegistroUsu, btnvalidDni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        getSupportActionBar().hide();

        edtDNIVali = (EditText)findViewById(R.id.editTextDNIvalid);
        edtContra = (EditText)findViewById(R.id.editTextContraRegis);
        edtReContra = (EditText)findViewById(R.id.editTextContraRe);
        btnRegistroUsu = (Button) findViewById(R.id.btnRegisNuevoUsu);
        btnvalidDni = (Button) findViewById(R.id.btnValidDniRegis);
        btnRegistroUsu.setEnabled(false);


        btnRegistroUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtDNIVali.getText().toString().length()>8 || edtDNIVali.getText().toString().isEmpty()) {
                    edtDNIVali.setError("DNI incorrecto");
                    return;
                }
                if (edtContra.getText().toString().isEmpty()){
                    edtContra.setError("Campo vacio");
                    return;
                }
                if(edtContra.getText().toString().equals(edtReContra.getText().toString())){
                    agregarUsuario();
                }else {
                    edtReContra.setError("No existe coincidencia");
                    return;
                }
            }
        });
        btnvalidDni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarUsuario();
            }
        });

    }

    public Connection conexionBD(){
        Connection conexion = null;
        try{
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.9;databaseName=essaludDBs;user=test;password=test");
            //192.168.0.2
            //Toast.makeText(getApplicationContext(), "conexion satisfactoria",Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT).show();

        }
        return conexion;

    }

    public void agregarUsuario(){
        try{
            PreparedStatement pst = conexionBD().prepareStatement("insert into usuariosCreados(DNI_Usuario, Contrasena_usuario) values(?,?);");
            pst.setString(1,edtDNIVali.getText().toString());
            pst.setString(2,edtContra.getText().toString());
            pst.executeUpdate();
            Intent intent = new Intent(Registro_Usuario.this,Menu.class);
            intent.putExtra("keydniregis",edtDNIVali.getText().toString());
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "REGISTRO SATISFACTORIO",Toast.LENGTH_SHORT).show();

        }catch (SQLException e){
            Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT).show();

        }
    }
    public void validarUsuario(){
        try {
            Statement st = conexionBD().createStatement();
            ResultSet rs = st.executeQuery( "select dni_paciente from paciente where dni_paciente = " + edtDNIVali.getText().toString());
            if (rs.next()){
                Toast.makeText(getApplicationContext(), "DNI EXISTE",Toast.LENGTH_LONG).show();
                edtDNIVali.setEnabled(false);
                btnRegistroUsu.setEnabled(true);
                btnRegistroUsu.setBackgroundColor((R.drawable.boton_ovalo_trans));
            }
            else{
                Toast.makeText(getApplicationContext(),"adios",Toast.LENGTH_LONG).show();
            }

        }catch (SQLException e){
            Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }
}
