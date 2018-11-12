package com.example.luisflores.eva1_practica_restaurantes;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Principal extends AppCompatActivity implements  ListView.OnItemClickListener{
    ListView listLista;
    Intent inDetalle;

    public static int iLlamar = 100;
    public static boolean bBande = false;
    Restaurante[] cClim = {
            new Restaurante("Barra fina", "Restaurante Gourmet", R.drawable.barrafina,"Periferico de la Juventud #312","Distrito 1","tel: 4425000"),
            new Restaurante("Bourke street bakery", "Café Gourmet", R.drawable.bourkestreetbakery,"Juan Escutia #512","Plaza Escutia","tel: 544420"),
            new Restaurante("Cafe dead end", "Café Gourmet", R.drawable.cafedeadend,"Juan Carrillo #587","Plaza Sur","tel: 250414"),
            new Restaurante("Cafe lois l", "Café Gourmet", R.drawable.cafeloisl,"Sonora #234","Plaza Sonorita","tel: 6145427275"),
            new Restaurante("Cafe lore", "Café Tradicional", R.drawable.cafelore,"Campo Bello #372","Plaza Basari","tel: 425257"),
            new Restaurante("Confessional", "Pizza Italiana", R.drawable.confessional,"Vallarta #456","Plaza Vallarta","tel: 53753"),
            new Restaurante("donostia", "Restaurante Gourmet", R.drawable.donostia,"Tecnologico #4353","Plaza Vallarta","tel: 78667"),
            new Restaurante("five leaves", "Restaurante Gourmet", R.drawable.fiveleaves,"Zaragosa #7322","Plaza Vallarta","tel: 78787"),
            new Restaurante("forkee restaurant", "Restaurante Gourmet", R.drawable.forkeerestaurant,"Lopez Carrillo #1231","Plaza Bazari","tel: 4535354"),
            new Restaurante("grahamavenue meats", "Restaurante Gourmet", R.drawable.grahamavenuemeats,"Julian Ahumada #36234","Plaza Sausito","tel: 354343"),
            new Restaurante("haigh schocolate", "Cafe Gourmet", R.drawable.haighschocolate,"Aldama #6223","Centro","tel: 434353"),
            new Restaurante("homei", "Cafe Gourmet", R.drawable.homei,"Cuarta #554","Centro","tel: 4425000"),
            new Restaurante("palomino espresso", "Cafe Tradicional", R.drawable.palominoespresso,"Octava #5555","Centro","tel: 45345338"),
            new Restaurante("petite oyster", "Cafe Tradicional", R.drawable.petiteoyster,"La quinta #743","Plaza Principal","tel: 453453"),
            new Restaurante("posatelier", "Cafe Tradicional", R.drawable.posatelier,"Ocampo #8452","Centro","tel: 4533453"),
            new Restaurante("teakha", "Restaurante Gourmet", R.drawable.teakha,"Doblado #53","Centro","tel: 78868"),
            new Restaurante("thai cafe", "Cafe Tradicional", R.drawable.thaicafe,"Melchor Ocampo #23","Centro","tel: 4535434"),
            new Restaurante("traif", "Restaurante Gourmet", R.drawable.traif,"Salinas #312","Centro","tel: 25664"),
            new Restaurante("up state", "Restaurante Gourmet", R.drawable.upstate,"Juarez #124","Centro","tel: 134324"),
            new Restaurante("waffle wolf", "Cafe Gourmet", R.drawable.wafflewolf,"Venustiano Carranza #12348","Centro","tel: 454533")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
// ------------------------------------ PERMISOS ------------------------------------
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            // SOLICITAR PERMISO
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    iLlamar);
        }else{
            bBande = true;
        }
// //////////////////////////////////// PERMISOS ////////////////////////////////////


        listLista = findViewById(R.id.listLista);
        listLista.setAdapter(
                new Adaptador_Restaurante(this, R.layout.restaurante, cClim)

        );

        inDetalle = new Intent(Principal.this, RestauranteDetalle.class);
        listLista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int iImagen = cClim[position].iImagen;
        inDetalle.putExtra("IMAGEN", iImagen);
        String aRestaurantes = cClim[position].sNombreResta;
        inDetalle.putExtra("RESTAURANTE", aRestaurantes);
        String sDesc = cClim[position].sDescripcion;
        inDetalle.putExtra("DESCRIPCION", sDesc);
        String sDireccion = cClim[position].sDireccion;
        inDetalle.putExtra("DIRECCION", sDireccion);
        String sPlaza= cClim[position].sPlaza;
        inDetalle.putExtra("PLAZA", sPlaza);
        String sTelefono = cClim[position].sTelefono;
        inDetalle.putExtra("TELEFONO", sTelefono);
        startActivity(inDetalle);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == iLlamar) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                bBande = true;
            }

        }
    }
}
