package com.montana.gimmemusic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class veritabani extends SQLiteOpenHelper {

    private static final String VERITABANI_ADI = "gimmemusic";

    public veritabani(@Nullable Context context) {
        super(context, VERITABANI_ADI, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE sarkilar (id INTEGER primary key AUTOINCREMENT, sarkino TEXT, sarki TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS sarkilar");
    }
}
