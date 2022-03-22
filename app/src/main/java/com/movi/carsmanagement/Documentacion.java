package com.movi.carsmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Documentacion extends AppCompatActivity {
ImageView ir1,ir2,ir3,ir4;
View ver;
//View ver = (View) findViewById(R.id.vista);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentacion);
ir1 = findViewById(R.id.facturabtnn);
ir2 = findViewById(R.id.circulacionbtn);
ir3 = findViewById(R.id.Segurobtn);
ir4 = findViewById(R.id.tenenciabtn);
ver = findViewById(R.id.vista);
ir1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ver.setBackgroundResource(R.drawable.facturaejemlo);
    }
});
        ir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ver.setBackgroundResource(R.drawable.circulacionicon);
            }
        });
        ir3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ver.setBackgroundResource(R.drawable.facturaejemlo);
            }
        });
        ir4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ver.setBackgroundResource(R.drawable.facturaejemlo);
            }
        });
    }
    }

