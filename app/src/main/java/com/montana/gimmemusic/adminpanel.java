package com.montana.gimmemusic;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class adminpanel extends AppCompatActivity {


    public veritabani db;
    Button kayitButton;
    EditText sarki;
    EditText sarkino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpanel);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);//karanlık mod açıldı
        getSupportActionBar().hide();//topbar kapatıldı
        db=new veritabani(this);
        sarkino=(EditText) findViewById(R.id.sarkino);
        sarki=(EditText) findViewById(R.id.sarki);
        kayitButton=(Button) findViewById(R.id.kayitButton);



        kayitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               sarkiKayit(sarkino.getText().toString(),sarki.getText().toString());
            }
        });

    }

    private void sarkiKayit(String sarkino, String sarki){
        SQLiteDatabase sldb = db.getReadableDatabase();
        ContentValues deger = new ContentValues();
        deger.put("sarkino",sarkino);
        deger.put("sarki",sarki);
        sldb.insert("gimmemusic",null,deger);
    }
}