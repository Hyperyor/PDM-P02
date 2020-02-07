package com.Bernal.pdm_p02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;

public class Valorar extends AppCompatActivity {

    private RatingBar barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valorar);

        barra = (RatingBar) findViewById(R.id.ratingBar);
    }

    public void enviarValoracion(View v) {
        Intent miIntent = new Intent(Valorar.this, MainActivity.class);

        int num = (int) barra.getRating();

        String valor = ""+num;

        miIntent.putExtra("valoracion", valor);

        setResult(RESULT_OK, miIntent);
        finish();
    }

    public void cancelarValoracion(View v) {

        setResult(RESULT_CANCELED);
        finish();
    }
}
