package com.movi.carsmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Cocheactivity extends AppCompatActivity {
    ImageView btngol;
    ImageView btnpolo;
    ImageView btntrans;
    ImageView btnwin;
    ImageView btngolr;
    ImageView btnpolor;
    ImageView btnpoloa;
    ImageView btnwhite;
    ImageView btnwhite2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocheactivity);
        btngol = findViewById(R.id.btngol18);
        btnpolo = findViewById(R.id.btnpolo20);
        btntrans = findViewById(R.id.btntrans);
        btnwin = findViewById(R.id.btnwins);
        btngolr = findViewById(R.id.btngolr20);
        btnpolor = findViewById(R.id.btnpolor20);
        btnpoloa = findViewById(R.id.btnpoloazu);
        btnwhite = findViewById(R.id.btnwhite);
        btnwhite2 = findViewById(R.id.btnwhite20);
        //**//
        btnwhite2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Principal.class);
            startActivity(intent);
            }
        });
        //**//
        btnwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Principal.class);
                startActivity(intent);
            }
        });
        //**//
        btnpoloa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Principal.class);
                startActivity(intent);
            }
        });
        //**//
        btnpolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Principal.class);
                startActivity(intent);
            }
        });
        //**//
        btngolr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Principal.class);
                startActivity(intent);
            }
        });
        //**//
        btnwin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Principal.class);
                startActivity(intent);
            }
        });
        //**//
        btntrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Principal.class);
                startActivity(intent);
            }
        });
        //**//
        btnpolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),  Principal.class);
                startActivity(intent);
            }
        });
        //**//
        btngol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Principal.class);
                startActivity(intent);
            }
        });
    }
}