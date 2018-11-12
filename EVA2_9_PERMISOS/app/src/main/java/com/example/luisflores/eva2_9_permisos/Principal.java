package com.example.luisflores.eva2_9_permisos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    EditText txtTelefono;
    Intent intent;
    final int iLlamar = 100;
    boolean bBande = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtTelefono = findViewById(R.id.txtTelefono);

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

    }

    public void click(View v) {
        if (bBande == true) {
            String sTel = "tel: " + txtTelefono.getText().toString();
            intent = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
            startActivity(intent);
        }else{
            Toast.makeText(this, "NO TIENES PERMISO PA LLAMAR PRRO", Toast.LENGTH_SHORT).show();

        }
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
