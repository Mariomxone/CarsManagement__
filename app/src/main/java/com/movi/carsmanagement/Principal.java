package com.movi.carsmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
    Button btnirr;
    Button btnsal;
    Button btnent;
    Button btngas;
    Button btnman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnirr = findViewById(R.id.docubtn);
        btnsal = findViewById(R.id.btnsalida);
        btnent = findViewById(R.id.btnenter);
        btngas = findViewById(R.id.btngas);
        btnman = findViewById(R.id.btnman);
        //**//
        btnman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Mantenimiento.class);
                startActivity(intent);
            }
        });
        //**//
        btngas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), gasolina.class);
                startActivity(intent);
            }
        });
        //**//
        btnent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Entrada.class);
                startActivity(intent);
            }
        });
        //*//
        btnsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), salidas.class);
                startActivity(intent);
            }
        });
        /**/
        btnirr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Documentacion.class);
                startActivity(intent);
            }
        });

    }

    }
