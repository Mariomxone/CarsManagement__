package com.movi.carsmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import Model.ApiService;
import Model.Carro;
import Model.Global;
import Model.User;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class salidas extends AppCompatActivity {

    TextView usuario;
    TextView km;
    TextView marca;
    TextView modelo;
    TextView anio;
    TextView color;
    TextView placa;
    TextView vin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salidas);

        km = findViewById(R.id.txtKm);
        marca = findViewById(R.id.txtMarca);
        modelo = findViewById(R.id.txtModelo);
        anio = findViewById(R.id.txtAnio);
        color = findViewById(R.id.txtColor);
        placa = findViewById(R.id.txtPlaca);
        vin = findViewById(R.id.txtVin);

        usuario = findViewById(R.id.txtUsuario);
        usuario.setText(Global.getUser());


        Toast.makeText(salidas.this,"Global.getCarro()" + Global.getCarro(),Toast.LENGTH_LONG).show();
        //Toast.makeText(MainActivity.this, "Server code unsuccesfull!"+ response.errorBody().string(), Toast.LENGTH_SHORT).show();

        fillCarInfo();


    }

    private void fillCarInfo() {

        Retrofit retrofit= Retroconf.getRetrofit();


        //Toast.makeText(MainActivity.this,retrofit.toString(), Toast.LENGTH_LONG).show();

        ApiService service = retrofit.create(ApiService.class);


        Call<Carro> call = service.getUser(Global.getCarro());




        //Toast.makeText(MainActivity.this, , Toast.LENGTH_LONG).show();


        call.enqueue(new Callback<Carro>() {
            @Override
            public void onResponse(Call<Carro> call, Response<Carro> response) {
                if(response.isSuccessful()){

                    Toast.makeText(getApplicationContext(), "Server code correct!" + response.body().getPlaca(), Toast.LENGTH_SHORT).show();
                    marca.setText(response.body().getMarca());
                    modelo.setText(response.body().getModelo());
                    anio.setText(response.body().getAnio());
                    color.setText(response.body().getColor());
                    placa.setText(response.body().getPlaca());
                    vin.setText(response.body().getVin());
                }
                else{

                    Toast.makeText(getApplicationContext(), "Server code correct!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Carro> call, Throwable t) {
                Log.d("Lokesh", "Data fail::" + t.toString());

                Toast.makeText(getApplicationContext(), "Data fail!"+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}