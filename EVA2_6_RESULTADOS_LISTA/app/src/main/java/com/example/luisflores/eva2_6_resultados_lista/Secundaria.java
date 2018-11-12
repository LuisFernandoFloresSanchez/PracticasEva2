package com.example.luisflores.eva2_6_resultados_lista;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Secundaria extends AppCompatActivity implements ListView.OnItemClickListener {

    ListView lstRestaurantes;

    Intent intentDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        lstRestaurantes = findViewById(R.id.lstResta);

        //CREAR ADAPTADOR

        // ASIGNAR ADAPTADOR
        lstRestaurantes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Datos.sRestaurantes));
        //LISTENER
        lstRestaurantes.setOnItemClickListener(this);
        intentDatos = getIntent();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        intentDatos.putExtra("RESTAURANTE", position);
        setResult(Activity.RESULT_OK, intentDatos);
        finish();
    }
}
