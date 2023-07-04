package com.montana.gimmemusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {
    Button btnbasla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);//karanlık mod açıldı
        getSupportActionBar().hide();//topbar kapatıldı

        btnbasla=(Button) findViewById(R.id.btnbasla);


        btnbasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity();
            }
        });

    }
    //diğer aktiviteye geçmek için açık intent oluşturduk
    public void changeActivity(){
        Intent intent= new Intent(MainActivity.this,AnaEkran.class);
        startActivity(intent);
    }




}