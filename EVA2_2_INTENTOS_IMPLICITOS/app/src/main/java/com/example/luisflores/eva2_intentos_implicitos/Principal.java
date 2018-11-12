package com.example.luisflores.eva2_intentos_implicitos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {
Intent inLanzarSecun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inLanzarSecun = new Intent(Principal.this,Secundaria.class);
    }

    public void click(View v ){

        startActivity(inLanzarSecun);

    }
}
