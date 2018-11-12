package com.example.luisflores.eva2_4_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements CheckBox.OnCheckedChangeListener {
    EditText txtNombre, txtApellido, txtEdad, txtSalario;
    CheckBox cbxTrabaja;
    RadioGroup rbgGenero;
    RadioButton rbtHombre, rbtMujer, rbtOtro;
    TextView lblSalario;
    Intent inSegunda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEdad = findViewById(R.id.txtEdad);
        txtSalario = findViewById(R.id.txtSalario);
        cbxTrabaja = findViewById(R.id.cbxTrabaja);
        rbgGenero = findViewById(R.id.rbgGenero);
        rbtHombre = findViewById(R.id.rbtHombre);
        rbtMujer = findViewById(R.id.rbtMujer);
        rbtOtro = findViewById(R.id.rbtOtro);
        lblSalario = findViewById(R.id.lblSalario);

        cbxTrabaja.setOnCheckedChangeListener(this);
        inSegunda = new Intent(this, Segunda.class);
    }

    public void segunda(View v) {
        String sNom = txtNombre.getText().toString();
        String sApe = txtApellido.getText().toString();
        int iEdad = Integer.parseInt(txtEdad.getText().toString());
        boolean bLabora = cbxTrabaja.isChecked();
        double sSal = Double.parseDouble(txtSalario.getText().toString());
        int iVal = rbgGenero.getCheckedRadioButtonId();
        int iGenero = 0;
        if (iVal == R.id.rbtHombre) {
            iGenero = 1;
        } else if (iVal == R.id.rbtMujer) {
            iGenero = 2;
        } else if (iVal == R.id.rbtOtro) {
            iGenero = 3;
        }
        Bundle bBundle = new Bundle();
        bBundle.putString("NOMBRE", sNom);
        bBundle.putString("APELLIDO", sApe);
        bBundle.putInt("EDAD", iEdad);
        bBundle.putBoolean("LABORA", bLabora);
        bBundle.putDouble("SALARIO", sSal);
        bBundle.putInt("GENERO", iGenero);
        inSegunda.putExtras(bBundle);
        startActivity(inSegunda);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        txtSalario.setEnabled(cbxTrabaja.isChecked());
        lblSalario.setEnabled(cbxTrabaja.isChecked());
    }
}
