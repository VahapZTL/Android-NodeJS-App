package com.example.caranbula.loginex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
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
