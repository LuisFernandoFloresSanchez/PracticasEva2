package com.example.luisflores.eva2_7_intentos_resultados;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    TextView lblResultado;
    Intent inContactos, inImagen,inMarcar;
    Uri uContactos, uImagen;
    int BUSCAR_CONTACTO = 1;
    int BUSCAR_IMAGEN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        lblResultado = findViewById(R.id.lblResultado);

        uContactos = ContactsContract.Contacts.CONTENT_URI;
        uImagen = Uri.parse("content://media/external/images/media");

        inContactos = new Intent(Intent.ACTION_CALL, uContactos);
        inImagen = new Intent(Intent.ACTION_VIEW, uImagen);
    }

    public void click(View v) {
        startActivityForResult(inContactos, BUSCAR_CONTACTO);

    }

    public void clickImagenes(View v) {
        startActivityForResult(inImagen, BUSCAR_IMAGEN);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == Activity.RESULT_OK) {
                String sResult = data.getDataString();
                lblResultado.setText(sResult);
                }
                break;
            case 2:
                if (resultCode == Activity.RESULT_OK) {
                    String sResult = data.getDataString();
                    lblResultado.setText(sResult);
                }
                break;
        }
    }
}
