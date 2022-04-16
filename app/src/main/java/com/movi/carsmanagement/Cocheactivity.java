package com.movi.carsmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import Model.Global;

public class Cocheactivity extends AppCompatActivity {
    ImageView [] carros = new ImageView[9];
    ImageView golPlata20;
    ImageView transit;
    ImageView windstar;
    ImageView golRojo20;
    ImageView poloRojo20;
    ImageView poloAzul20;
    ImageView poloBlanco20ing;
    ImageView poloBlanco20lic;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocheactivity);

        carros[0] = (ImageView) findViewById(R.id.btnGolPlata18);
        carros[1] = (ImageView) findViewById(R.id.btnGolPlata20);
        carros[2] = (ImageView) findViewById(R.id.btnTransit);
        carros[3] = (ImageView) findViewById(R.id.btnWindstar);
        carros[4] = (ImageView) findViewById(R.id.btnGolRojo20);
        carros[5] = (ImageView) findViewById(R.id.btnPoloRojo20);
        carros[6] = (ImageView) findViewById(R.id.btnPoloAzul20);
        carros[7] = (ImageView) findViewById(R.id.btnPoloBlanco20ing);
        carros[8] = (ImageView) findViewById(R.id.btnPoloBlanco20lic);

        for(int i = 0; i<9; i++){
            carros[i].setTag(i);
            carros[i].setOnClickListener(this::onClick);
        }





    }

    public void onClick(View v) {
        Global.setCarro(Integer.parseInt((String) v.getContentDescription() ));
        //Log.i("Hola", String.valueOf(Integer.parseInt((String) v.getTag() )));
        Intent intent = new Intent(v.getContext(), Principal.class);
        startActivity(intent);

    }


}



