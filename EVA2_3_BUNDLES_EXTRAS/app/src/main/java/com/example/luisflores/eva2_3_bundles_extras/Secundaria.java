package com.example.luisflores.eva2_3_bundles_extras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {
    TextView lblTexto;
    Intent inLeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        lblTexto = findViewById(R.id.lblTexto);

        inLeer = getIntent();
        lblTexto.setText(inLeer.getStringExtra("MENSAJE"));

    }

    public void cerrar(View v) {

        finish();
    }
}
