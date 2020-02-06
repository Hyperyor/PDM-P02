package com.Bernal.pdm_p02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Visualizar extends AppCompatActivity {

    private TextView nombre;
    private TextView apellido;
    private TextView edad;
    private TextView media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        nombre = (TextView) findViewById(R.id.textoNombre);

        apellido = (TextView) findViewById(R.id.textoApellido);

        edad = (TextView) findViewById(R.id.textoEdad);

        media = (TextView) findViewById(R.id.textoMedia);

        Bundle user = this.getIntent().getExtras();

        if(user.getString("nombre").equals(""))
        {
            nombre.setText("Sin datos");
        }
        else
        {
            nombre.setText(user.getString("nombre"));
        }

        if(user.getString("apellido").equals(""))
        {
            apellido.setText("Sin datos");
        }
        else
        {
            apellido.setText(user.getString("apellido"));
        }

        if(user.getInt("edad") <= 0)
        {
            edad.setText("Sin datos");
        }
        else
        {
            edad.setText(""+user.getInt("edad"));
        }

        media.setText(""+user.getFloat("media"));
    }

    public void volverAMain(View v) {

        finish();
    }
}
