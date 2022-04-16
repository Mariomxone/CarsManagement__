package com.movi.carsmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
    Button btnirr;
    Button btnsal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnirr = findViewById(R.id.docubtn);
        btnsal = findViewById(R.id.btnSalida);

        String carro = getIntent().getStringExtra("carro");
        btnsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), salidas.class).putExtra("carro",carro);
                startActivity(intent);
            }
        });
        /**/
        btnirr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Documentacion.class).putExtra("carro",carro);
                startActivity(intent);

            }
        });

    }

    }
