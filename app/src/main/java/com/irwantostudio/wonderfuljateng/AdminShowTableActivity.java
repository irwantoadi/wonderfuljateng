package com.irwantostudio.wonderfuljateng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class AdminShowTableActivity extends AppCompatActivity {

    String tabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_show_table);

        Intent i = getIntent();
        tabel = i.getStringExtra("tabel");
        setTitle(tabel);
    }
}
