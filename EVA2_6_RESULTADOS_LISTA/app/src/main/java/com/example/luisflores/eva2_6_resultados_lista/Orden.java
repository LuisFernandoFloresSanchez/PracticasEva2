package com.example.luisflores.eva2_6_resultados_lista;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Orden extends AppCompatActivity {
    EditText txtOrden, txtPrecio;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden);
        txtOrden = findViewById(R.id.txtOrdenes2);
        txtPrecio = findViewById(R.id.txtPrecio);
        intent = getIntent();
    }

    public void calcCosto(View v) {
        int iCant = Integer.parseInt(txtOrden.getText().toString());
        Double dPrecio = Double.parseDouble(txtPrecio.getText().toString());

        intent.putExtra("TOTAL", (iCant * dPrecio));
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
