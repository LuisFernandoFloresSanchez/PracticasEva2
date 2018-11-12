package com.example.luisflores.eva2_8_listas_personalizadas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements ListView.OnItemClickListener {

    ListView listLista;
    Intent inDetalle;
    Clima[] cClim = {
            new Clima("CHIHUAHUA", 11, "Nublado", R.drawable.cloudy),
            new Clima("DELICIAS", 8, "Lluvioso", R.drawable.rainy),
            new Clima("JUAREZ", 15, "Soleado", R.drawable.sunny),
            new Clima("MADERA", 10, "Chispeando", R.drawable.light_rain), new Clima("CHIHUAHUA", 11, "Nublado", R.drawable.cloudy),
            new Clima("CAMARGO", 17, "Lluvioso", R.drawable.rainy),
            new Clima("PARRAL", 26, "Soleado", R.drawable.sunny),
            new Clima("ALDAMA", 5, "Chispeando", R.drawable.light_rain),
            new Clima("CUAHUTEMOC", 19, "Chispeando", R.drawable.light_rain),
            new Clima("JIMENEZ", 13, "Lluvioso", R.drawable.rainy),
            new Clima("GUERRERO", 21, "Soleado", R.drawable.sunny),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        listLista = findViewById(R.id.listLista);
        listLista.setAdapter(
                new WeatherAdapter(this, R.layout.layout_clima, cClim)

        );

        inDetalle = new Intent(Principal.this, ClimaDetalle.class);
        listLista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int iImagen = cClim[position].iImagen;
        inDetalle.putExtra("IMAGEN", iImagen);

        String sCiudad = cClim[position].sNombreCiudad;
        inDetalle.putExtra("CIUDAD", sCiudad);
        int iTemp = cClim[position].iTemperatura;
        inDetalle.putExtra("TEMPERATURA",iTemp);
        String sDesc = cClim[position].sDescripcion;
        inDetalle.putExtra("DESCRIPCION", sDesc);
        startActivity(inDetalle);
    }
}
