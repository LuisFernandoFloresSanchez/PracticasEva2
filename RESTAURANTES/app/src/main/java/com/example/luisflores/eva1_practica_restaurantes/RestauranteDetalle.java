package com.example.luisflores.eva1_practica_restaurantes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RestauranteDetalle extends AppCompatActivity {
    RelativeLayout rlLayout;
    TextView lblRestaurante;
    TextView lblDescripcion;
    TextView lblDireccion;
    TextView lblPlaza;
    TextView lblTelefono;
    Intent inDatos;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_detalle);

        rlLayout = findViewById(R.id.rlLayout);
        lblRestaurante = findViewById(R.id.lblRestaurantedet);
        lblDescripcion = findViewById(R.id.lblDescripciondet);
        lblDireccion = findViewById(R.id.lblDireccion);
        lblPlaza = findViewById(R.id.lblPlaza);
        lblTelefono = findViewById(R.id.lblTelefono);
        inDatos = getIntent();

        rlLayout.setBackgroundResource(inDatos.getIntExtra("IMAGEN", R.drawable.bourkestreetbakery));
        lblRestaurante.setText(inDatos.getStringExtra("RESTAURANTE"));
        lblDescripcion.setText(inDatos.getStringExtra("DESCRIPCION"));
        lblDireccion.setText(inDatos.getStringExtra("DIRECCION"));
        lblPlaza.setText(inDatos.getStringExtra("PLAZA"));
        lblTelefono.setText(inDatos.getStringExtra("TELEFONO"));
    }

    public void click(View v) {
        if (Principal.bBande == true) {
            String sTel = lblTelefono.getText().toString();
            intent = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
            startActivity(intent);
        }else{
            Toast.makeText(this, "NO TIENES PERMISO PA LLAMAR PRRO", Toast.LENGTH_SHORT).show();

        }
    }

}
