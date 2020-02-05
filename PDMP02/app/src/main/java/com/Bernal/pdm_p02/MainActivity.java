package com.Bernal.pdm_p02;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements OnClickListener{

    private String nombreUsuario = "";

    private String apellidoUsuario = "";

    private int edadUsuario = -1;

    private int contadorValoraciones = 0;

    private int acumuladorValoraciones = 0;

    private Button boton_registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Acción del botón salir resuelto con Java y el interfaz OnClickListener.
         * Se necesita implementar dicho interfaz */
        Button botonSalida= (Button) findViewById(R.id.botonSalir);
        botonSalida.setOnClickListener(this);

        /** Acción del botón salir resuelto con Java y clase anónima.
         * No necesita implementar el intefaz: El método onClick() va definido
         * dentro de la instacia de la clase OnClickListener */
        boton_registro = (Button) findViewById(R.id.Registro);

        boton_registro.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intentRegistro = new Intent(MainActivity.this, Registro.class);

                Bundle user = new Bundle();

                user.putString("nombre", nombreUsuario);

                user.putString("apellido", apellidoUsuario);

                user.putInt("edad", edadUsuario);

                intentRegistro.putExtras(user);

                startActivityForResult(intentRegistro, 11);


            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            if (requestCode == 11) {

                nombreUsuario = data.getExtras().getCharSequence("nombre").toString();

                apellidoUsuario = data.getExtras().getCharSequence("apellido").toString();

                edadUsuario = Integer.parseInt(data.getExtras().getCharSequence("edad").toString());

                boton_registro.setText("Editar");

                /*Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                nombreUsuario + " " + " " + apellidoUsuario + " " + edadUsuario, Toast.LENGTH_SHORT);

                toast1.show();*/
                    /** Usamos data.getExtras() si la hija usa putExtra() *
                     *  o data.getData() si la hija usa setData()         */


            }

        }

    }

    /** Acción del botón Fin resuelto con Java y implementando
     * el método onClick() del interfaz*/
    @Override
    public void onClick(View v) {
        finish();
        System.exit(0);
    }
}
