package com.Bernal.pdm_p02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        /** Acción del botón salir resuelto con Java y clase anónima.
         * No necesita implementar el intefaz: El método onClick() va definido
         * dentro de la instacia de la clase OnClickListener */
        Button boton_ok = (Button) findViewById(R.id.botonOk);

        boton_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                TextView nombre = (TextView) findViewById(R.id.textoNombre);

                TextView apellido = (TextView) findViewById(R.id.textoApellido);

                TextView edad = (TextView) findViewById(R.id.numberEdad);

                Intent miIntent = new Intent(Registro.this, MainActivity.class);

                if(!nombre.getText().toString().equals("") && !apellido.getText().toString().equals("") && !edad.getText().toString().equals(""))
                {
                    Bundle datos = new Bundle();

                    datos.putString("nombre", nombre.getText().toString());

                    datos.putString("apellido", apellido.getText().toString());

                    datos.putInt("edad", Integer.parseInt(edad.getText().toString()));

                    miIntent.putExtras(datos);
                }

                startActivity(miIntent);
            }
        });
    }
}
