package com.example.luisflores.eva2_6_resultados_lista;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    Intent intent, intentOrden;
    TextView lblTexto,lblTotal;
    int iLista = 13;
    int iOrden = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lblTexto = findViewById(R.id.lblTexto2);
        lblTotal = findViewById(R.id.lblTotal);
        intent = new Intent(this, Secundaria.class);
        intentOrden = new Intent(this, Orden.class);
    }

    public void click(View v) {
        startActivityForResult(intent, iLista);
    }

    public void clickOrden(View v) {
        startActivityForResult(intentOrden, iOrden);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == iLista) {
            if (resultCode == Activity.RESULT_OK) {
                int iResta = data.getIntExtra("RESTAURANTE", 0);
                lblTexto.setText(Datos.sRestaurantes[iResta]);
            }
        } else if(requestCode == iOrden){
            if (resultCode == Activity.RESULT_OK) {
                double dResta = data.getDoubleExtra("TOTAL", 0);
                lblTotal.setText("$ " + dResta);
            }
        }
    }
}
