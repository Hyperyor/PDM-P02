package com.Bernal.pdm_p02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private TextView nombre;

    private TextView apellido;

    private TextView edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = (TextView) findViewById(R.id.textoNombre);

        apellido = (TextView) findViewById(R.id.textoApellido);

        edad = (TextView) findViewById(R.id.numberEdad);


        Bundle user = this.getIntent().getExtras();

        nombre.setText(user.getString("nombre"));

        apellido.setText(user.getString("apellido"));

        if(user.getInt("edad") != -1)
        {
            String edadStr = "" + user.getInt("edad");
            edad.setText(edadStr);
        }


        /** Acción del botón salir resuelto con Java y clase anónima.
         * No necesita implementar el intefaz: El método onClick() va definido
         * dentro de la instacia de la clase OnClickListener */
        Button boton_ok = (Button) findViewById(R.id.botonOk);

        boton_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(Registro.this, MainActivity.class);

                if(!nombre.getText().toString().equals("") && !apellido.getText().toString().equals("") && !edad.getText().toString().equals(""))
                {
                    //Bundle datos = new Bundle();

                    miIntent.putExtra("nombre", nombre.getText().toString());

                    miIntent.putExtra("apellido", apellido.getText().toString());

                    miIntent.putExtra("edad", edad.getText().toString());

                    //miIntent.putExtras(datos);

                    setResult(RESULT_OK, miIntent);
                }
                else {

                    setResult(RESULT_CANCELED);
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "No se han introducido datos", Toast.LENGTH_SHORT);

                    toast1.show();
                }

                finish();
            }
        });
    }



    public void clickCancelar(View vista)
    {
        Intent miIntent = new Intent(Registro.this, MainActivity.class);

        setResult(RESULT_CANCELED);
        //startActivity(miIntent);

        finish();


    }
}
