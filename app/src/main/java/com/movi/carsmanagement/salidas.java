package com.movi.carsmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import Conf.ApiService;
import Model.Carro;
import Conf.Global;
import Model.Salida;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class salidas extends AppCompatActivity {

    Button guardarSalida;

    TextView usuario;
    TextView km;
    TextView marca;
    TextView modelo;
    TextView anio;
    TextView color;
    TextView placa;
    TextView vin;


    CheckBox poliza;
    CheckBox circulacion;
    CheckBox verificacion;
    CheckBox tenencia;
    CheckBox llanta;
    CheckBox gato;
    CheckBox cruceta;
    CheckBox extintor;
    EditText observaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salidas);

        //Datos llenados por el usuario

        poliza = findViewById(R.id.cbPoliza);
        circulacion = findViewById(R.id.cbCirculacion);
        verificacion = findViewById(R.id.cbVerificacion);
        tenencia = findViewById(R.id.cbTenencia);
        llanta = findViewById(R.id.cbLlanta);
        gato = findViewById(R.id.cbGato);
        cruceta = findViewById(R.id.cbCruceta);
        extintor = findViewById(R.id.cbExtintor);
        observaciones = findViewById(R.id.etObservaciones);

        guardarSalida = (Button) findViewById(R.id.btnGuardarSalida);


        //Datos llenados desde la bse de datos
        km = findViewById(R.id.txtKm);
        marca = findViewById(R.id.txtMarca);
        modelo = findViewById(R.id.txtModelo);
        anio = findViewById(R.id.txtAnio);
        color = findViewById(R.id.txtColor);
        placa = findViewById(R.id.txtPlaca);
        vin = findViewById(R.id.txtVin);

        usuario = findViewById(R.id.txtUsuario);
        usuario.setText(Global.getUser());

        fillCarInfo();

        guardarSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkout();
            }
        });


    }

    private void fillCarInfo() {

        Retrofit retrofit= Retroconf.getRetrofit();

        ApiService service = retrofit.create(ApiService.class);


        Call<Carro> call = service.getUser(Global.getCarro());




        //Toast.makeText(MainActivity.this, , Toast.LENGTH_LONG).show();


        call.enqueue(new Callback<Carro>() {
            @Override
            public void onResponse(Call<Carro> call, Response<Carro> response) {

                    //Toast.makeText(getApplicationContext(), "Server code correct!" + response.body().getPlaca(), Toast.LENGTH_SHORT).show();
                    marca.setText(response.body().getMarca());
                    modelo.setText(response.body().getModelo());
                    anio.setText(response.body().getAnio());
                    color.setText(response.body().getColor());
                    placa.setText(response.body().getPlaca());
                    vin.setText(response.body().getVin());

            }

            @Override
            public void onFailure(Call<Carro> call, Throwable t) {
                Log.d("Lokesh", "Data fail::" + t.toString());

                Toast.makeText(getApplicationContext(), "Error inesperado"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void checkout(){
        Retrofit retrofit= Retroconf.getRetrofit();

        ApiService service = retrofit.create(ApiService.class);

        Salida salida = new Salida(poliza.isChecked(),circulacion.isChecked(),verificacion.isChecked(),tenencia.isChecked(),llanta.isChecked(),gato.isChecked(),cruceta.isChecked(),extintor.isChecked(),observaciones.getText().toString(),Global.getUserId(),Global.getCarro());

        Call<Salida> call = service.guardarSalida(salida);

        call.enqueue(new Callback<Salida>() {
            @Override
            public void onResponse(Call<Salida> call, Response<Salida> response) {
                if(response.isSuccessful()){
                    Toasty.success(getApplicationContext(), "Salida completada correctamente", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), Cocheactivity.class);
                    startActivity(intent);
                }
                else{
                    try {
                        Toast.makeText(getApplicationContext(),"Datos corruptos" +response.errorBody().string() ,Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<Salida> call, Throwable t) {
                Log.d("Lokesh", "Error de conexión con el servidor" + t.toString());

                Toast.makeText(getApplicationContext(), "Error de conexión con el servidor"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}