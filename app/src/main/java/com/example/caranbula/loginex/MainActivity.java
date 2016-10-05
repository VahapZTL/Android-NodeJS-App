package com.example.caranbula.loginex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.caranbula.loginex.data.GetLoginRes;
import com.example.caranbula.loginex.data.MyApi;
import com.example.caranbula.loginex.data.RegisterData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView email_tv, pass_tv;
    Button login_but, register_buton;
    public static Boolean ConStatus;
    public static String AccesToken, UserID;

    final Intent registerAct = new Intent(this, RegisterActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email_tv = (TextView) findViewById(R.id.editText1);
        pass_tv = (TextView) findViewById(R.id.editText2);
        login_but = (Button) findViewById(R.id.login_buton);
        register_buton = (Button) findViewById(R.id.register_but);

        login_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<GetLoginRes> call = startRetrofit().sendLogin(new loginPost(email_tv.getText().toString()
                                                                                ,pass_tv.getText().toString()));

                call.enqueue(new Callback<GetLoginRes>() {
                    @Override
                    public void onResponse(Call<GetLoginRes> call, Response<GetLoginRes> response) {
                        ConStatus = Boolean.valueOf(response.body().getStatus());
                        AccesToken = response.body().getData();
                        UserID = response.body().getUserID();
                    }

                    @Override
                    public void onFailure(Call<GetLoginRes> call, Throwable t) {
                        Log.v("Error: ", t.getMessage());
                    }
                });
            }
        });

        register_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registerAct);
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

    public class loginPost{
        String email;
        String password;

        public loginPost(String email, String password){
            this.email = email;
            this.password = password;
        }
    }
}
