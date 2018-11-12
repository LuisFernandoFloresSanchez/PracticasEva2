package com.example.luisflores.eva2_3_bundles_extras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Principal extends AppCompatActivity {
    Intent inSegunda;
    EditText txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtNombre = findViewById(R.id.txtNombre);

        inSegunda = new Intent(this, Secundaria.class);
    }

    public void click(View v) {
        String sVal = txtNombre.getText().toString();
        inSegunda.putExtra("MENSAJE",sVal);
        startActivity(inSegunda);
    }
}
