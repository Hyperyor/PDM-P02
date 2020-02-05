package com.Bernal.pdm_p02;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private String nombreUsuario = "";

    private String apellidoUsuario = "";

    private int edadUsuario = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Acción del botón salir resuelto con Java y clase anónima.
         * No necesita implementar el intefaz: El método onClick() va definido
         * dentro de la instacia de la clase OnClickListener */
        Button boton_registro = (Button) findViewById(R.id.Registro);

        boton_registro.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intentRegistro = new Intent(MainActivity.this, Registro.class);
                startActivity(intentRegistro);
            }
        });

        Bundle datos = this.getIntent().getExtras();

        if(datos != null)
        {
            nombreUsuario = datos.getString("nombre");

            apellidoUsuario = datos.getString("apellido");

            edadUsuario = datos.getInt("edad");

            Log.i("Recibido", nombreUsuario + " " + apellidoUsuario + " " + edadUsuario);
        }
        else
        {
            Log.i("Recibido", "No se han recibido datos");
        }


    }
}
