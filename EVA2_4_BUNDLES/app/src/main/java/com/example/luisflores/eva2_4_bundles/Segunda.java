package com.example.luisflores.eva2_4_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Segunda extends AppCompatActivity {
    TextView lblTexto;
    Intent inLeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        lblTexto = findViewById(R.id.lblTexto);

        inLeer = getIntent();
        Bundle bDatos = inLeer.getExtras();
        lblTexto.append("\nNombre: " + bDatos.getString("NOMBRE"));
        lblTexto.append("\nApellido: " + bDatos.getString("APELLIDO"));
        lblTexto.append("\nEdad: " + bDatos.getInt("EDAD"));
        if (bDatos.getBoolean("LABORA")) {
            lblTexto.append("\nSi trabaja ");
            lblTexto.append("\nSalario: $" + bDatos.getDouble("SALARIO"));
        } else {
            lblTexto.append("\nNo trabaja es un zangano");
        }

        switch (bDatos.getInt("GENERO")) {
            case 1:
                lblTexto.append("\nGenero: " + "Masculino");
                break;
            case 2:
                lblTexto.append("\nGenero: " + "Femenino");
                break;
            case 3:
                lblTexto.append("\nGenero: " + "Otro");
                break;
        }

    }

    public void cerrar(View v) {
        finish();

    }
}
