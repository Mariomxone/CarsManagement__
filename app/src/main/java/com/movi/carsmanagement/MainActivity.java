package com.movi.carsmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import Model.ApiService;
import Model.Global;
import Model.User;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button btnir;
    EditText txtUsuario;
    EditText txtPassword;

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
                btnir.setClickable(false);
                loginUser();


            }
        });


    }

    private void loginUser() {

        Retrofit retrofit= Retroconf.getRetrofit();


        //Toast.makeText(MainActivity.this,retrofit.toString(), Toast.LENGTH_LONG).show();

        ApiService service = retrofit.create(ApiService.class);

        User user = new User(txtUsuario.getText().toString(),txtPassword.getText().toString());

        Call<User> call =service.loginUser(user);



        //Toast.makeText(MainActivity.this, , Toast.LENGTH_LONG).show();


        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Global.setUser(txtUsuario.getText().toString());
                    Toast.makeText(MainActivity.this, "Server code correct!"+ response.toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Cocheactivity.class);
                    startActivity(intent);
                }
                else{
                    btnir.setClickable(true);
                    try {
                        Toast.makeText(MainActivity.this, "Server code unsuccesfull!"+ response.errorBody().string(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Lokesh", "Login fail::" + t.toString());

                Toast.makeText(MainActivity.this, "Login fail!"+t.toString(), Toast.LENGTH_SHORT).show();
                btnir.setClickable(true);
            }
        });


    }
}