package com.movi.carsmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import Conf.ApiService;
import Conf.Global;
import Model.User;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    Button btnir;
    EditText txtUsuario;
    EditText txtPassword;
    ProgressDialog progressDialog;
    Call<User> call;
    boolean finished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnir = findViewById(R.id.btnIniciar);
        txtUsuario = (EditText)  findViewById(R.id.txtUser);
        txtPassword = (EditText) findViewById(R.id.txtPassword);


        btnir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finished =false;
                loginUser();
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Validado credenciales"); // Setting Message
                progressDialog.setTitle("Inicio de sesión"); // Setting Title
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                progressDialog.show(); // Display Progress Dialog
                progressDialog.setCancelable(false);
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            while (finished == false){
                                Thread.sleep(500);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                    }
                }).start();



            }
        });


    }

    private void loginUser() {

        Retrofit retrofit= Retroconf.getRetrofit();


        //Toast.makeText(MainActivity.this,retrofit.toString(), Toast.LENGTH_LONG).show();

        ApiService service = retrofit.create(ApiService.class);

        User user = new User(txtUsuario.getText().toString(),txtPassword.getText().toString());

        call =service.loginUser(user);


        if(call.isExecuted()){
            return;
        }
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                finished = true;
                if(response.isSuccessful()){
                    Global.setUser(txtUsuario.getText().toString());
                    Global.setUserId(response.body().getId());
                    Toasty.success(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT, true).show();
                    Intent intent = new Intent(getApplicationContext(), Cocheactivity.class);
                    finishAffinity();
                    startActivity(intent);
                }
                else{
                    btnir.setClickable(true);
                    try {

                        Toasty.warning(MainActivity.this, response.errorBody().string(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                finished = true;
                Log.d("Lokesh", "Login fail::" + t.toString());

                Toasty.error(MainActivity.this, "Error de comunicación con el servidor"+t.getMessage(), Toast.LENGTH_SHORT).show();
                btnir.setClickable(true);
            }
        });


    }
}