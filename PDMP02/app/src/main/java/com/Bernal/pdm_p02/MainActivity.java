package com.Bernal.pdm_p02;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements OnClickListener{

    private String nombreUsuario = "";

    private String apellidoUsuario = "";

    private int edadUsuario = -1;

    private int contadorValoraciones = 0;

    private int acumuladorValoraciones = 0;

    private TextView vecesValorada;

    private Button boton_registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Ciclo de vida", "Estamos en el OnCreate");

        vecesValorada = (TextView) findViewById(R.id.vecesValoradaNumero);

        vecesValorada.setText(""+contadorValoraciones);

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

                if(requestCode == 22)
                {
                    contadorValoraciones ++;

                    vecesValorada.setText(""+contadorValoraciones);
                    //Log.i("Control", data.getExtras().getCharSequence("valoracion").toString());



                    acumuladorValoraciones += Integer.parseInt(data.getExtras().getCharSequence("valoracion").toString());

 /*                   Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    R.string.vecesValorada  + contadorValoraciones , Toast.LENGTH_SHORT);

                    toast1.show();*/
                }
                else
                {


                    if(requestCode == 11) {

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

    }

    public void cambiarAValorar(View v) {
        Intent intentValorar = new Intent(MainActivity.this, Valorar.class);

        startActivityForResult(intentValorar, 22);
    }

    public void cambiarAVisualizar(View v) {
        Intent intentVisualizar = new Intent(MainActivity.this, Visualizar.class);

        Bundle data = new Bundle();

        data.putString("nombre", nombreUsuario);

        data.putString("apellido", apellidoUsuario);

        data.putInt("edad", edadUsuario);

        float media = 0.0f;

        if(contadorValoraciones != 0)
        {
            media = acumuladorValoraciones / contadorValoraciones;
        }

        data.putFloat("media", media);

        intentVisualizar.putExtras(data);

        startActivity(intentVisualizar);
    }

    /** Acción del botón Fin resuelto con Java y implementando
     * el método onClick() del interfaz*/
    @Override
    public void onClick(View v) {
        finish();
        System.exit(0);
    }

    @Override protected void onStart() {
        super.onStart();
        Log.i("Ciclo de vida", "Estamos en el OnStart");
    }

    @Override protected void onResume() {
        super.onResume();
        Log.i("Ciclo de vida", "Estamos en el OnResume");
    }

    @Override protected void onPause() {
        Log.i("Ciclo de vida", "Estamos en el OnPause");
        super.onPause();
    }

    @Override protected void onStop() {
        Log.i("Ciclo de vida", "Estamos en el OnStop");
        super.onStop();
    }

    @Override protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de vida", "Estamos en el OnRestart");
    }

    @Override protected void onDestroy() {
        Log.i("Ciclo de vida", "Estamos en el OnDestroy");
        super.onDestroy();
    }
}
