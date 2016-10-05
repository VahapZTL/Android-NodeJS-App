package com.example.caranbula.loginex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caranbula.loginex.data.GetRegisterRes;
import com.example.caranbula.loginex.data.MyApi;
import com.example.caranbula.loginex.data.RegisterData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, password;
    Button reg_buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        name = (EditText) findViewById(R.id.name_et);
        email = (EditText) findViewById(R.id.email_et);
        password = (EditText) findViewById(R.id.password_et);

        reg_buton = (Button) findViewById(R.id.register_but);

        reg_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<RegisterData> call = startRetrofit().sendRegister(new registerPost(name.getText().toString(),
                                                                                    email.getText().toString(),
                                                                                    password.getText().toString()));

                call.enqueue(new Callback<RegisterData>() {
                    @Override
                    public void onResponse(Call<RegisterData> call, Response<RegisterData> response) {
                        Toast.makeText(RegisterActivity.this, "Login Suucessfully!" , Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<RegisterData> call, Throwable t) {
                        Log.v("Response", t.getMessage());
                    }
                });
            }
        });
    }

    MyApi startRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApi myApi = retrofit.create(MyApi.class);
        return myApi;
    }

    public class registerPost{
        String name;
        String email;
        String password;

        public registerPost(String name, String email, String password){
            this.name = name;
            this.email = email;
            this.password = password;
        }
    }
}
