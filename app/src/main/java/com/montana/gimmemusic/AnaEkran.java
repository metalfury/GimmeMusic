package com.montana.gimmemusic;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class AnaEkran extends AppCompatActivity  {


    private Spinner duyguSpinner;//spinner tanımlanması
    Button btnRastgele;
    Button btnGimme;
    TextView gosterTextview;
    Button admin;
    private veritabani db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anaekran);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);//karanlık mod açıldı
        getSupportActionBar().hide();//topbar kapatıldı


        duyguSpinner = findViewById(R.id.duyguSpinner);//spinner adaptörünün tanımlanması
        db=new veritabani(this);
        btnGimme=(Button) findViewById(R.id.btnGimme);
        btnRastgele=(Button) findViewById(R.id.btnRastgele) ;
        gosterTextview=(TextView) findViewById(R.id.gosterTextview);
        admin=(Button) findViewById(R.id.admin);

        String[] duygular = getResources().getStringArray(R.array.duygu_array);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,duygular);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        duyguSpinner.setAdapter(adapter);
        String spinnerText = duyguSpinner.getSelectedItem().toString();
        // burada spinner textteki veriyi okuyarak veritabanından veriyi çekerken kullanacaktım.

        btnGimme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               gosterTextview.setText(Listele().toString());
            }
        });

        btnRastgele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adminActivity();
            }
        });

    }
    public void adminActivity(){
        Intent intent2= new Intent(AnaEkran.this,adminpanel.class);
        startActivity(intent2);
    }
    public Cursor Listele(){
        String[] sutunlar={"sarkino", "sarki"};
        SQLiteDatabase sldb = db.getReadableDatabase();
        Cursor cursor = sldb.query("gimmemusic",sutunlar,"*",null,null,null,"RANDOM()", String.valueOf(1));
        return cursor;
    }


}