package com.example.luisflores.eva1_practica_restaurantes;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Adaptador_Restaurante extends ArrayAdapter<Restaurante> {
    Context cContexto;
    int iLayout;
    Restaurante[] aRestaurantes;

    public Adaptador_Restaurante(@NonNull Context context, int resource, @NonNull Restaurante[] objects) {
        super(context, resource, objects);
        cContexto = context;
        iLayout = resource;
        aRestaurantes = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LinearLayout llLinear;
        TextView lblRestaurante;
        TextView lblDescripcion;

        View fila = convertView;
        if (fila == null) { //Si es nulo no existe nuestra fila, hay que crearla
            LayoutInflater liVista = ((Activity) cContexto).getLayoutInflater();
            fila = liVista.inflate(iLayout, parent, false);

        }
        // [[[[[[[[[[[[[[[[[[[[[[Vincular los widgets ]]]]]]]]]]]]]]]]]]]]]]]]]]]]
        llLinear = fila.findViewById(R.id.linear);
        lblRestaurante = fila.findViewById(R.id.lblRestaurante);
        lblDescripcion = fila.findViewById(R.id.lblDescripcion);


        //{{{{{{{{{{{{{{{{{{{{{{{{{{{{ Llenar datos }}}}}}}}}}}}}}}}}}}}}}}}}}}}}}
        Restaurante cActual = aRestaurantes[position];

        llLinear.setBackgroundResource(cActual.iImagen);
        lblRestaurante.setText(cActual.sNombreResta);
        lblDescripcion.setText(cActual.sDescripcion);
        return fila;
    }


}
