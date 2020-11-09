package com.irwantostudio.wonderfuljateng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminActivity extends AppCompatActivity {

    private CardView card_batas_wilayah, card_gambar_kuliner, card_gambar_wisata, card_icon_kab,
            card_kabupaten, card_kuliner, card_link, card_user, card_wisata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        card_batas_wilayah = findViewById(R.id.card_batas_wilayah);
        card_gambar_kuliner = findViewById(R.id.card_gambar_kuliner);
        card_gambar_wisata = findViewById(R.id.card_gambar_wisata);
        card_icon_kab = findViewById(R.id.card_icon_kab);
        card_kabupaten = findViewById(R.id.card_kabupaten);
        card_kuliner = findViewById(R.id.card_kuliner);
        card_link = findViewById(R.id.card_link);
        card_user = findViewById(R.id.card_user);
        card_wisata = findViewById(R.id.card_wisata);

        card_batas_wilayah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminActivity.this, AdminShowTableActivity.class);
                i.putExtra("tabel", "tabel_batas_wilayah");
                startActivity(i);
            }
        });
        card_gambar_kuliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminActivity.this, AdminShowTableActivity.class);
                i.putExtra("tabel", "tabel_gambar_kuliner");
                startActivity(i);
            }
        });
        card_gambar_wisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminActivity.this, AdminShowTableActivity.class);
                i.putExtra("tabel", "tabel_gambar_wisata");
                startActivity(i);
            }
        });
        card_icon_kab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminActivity.this, AdminShowTableActivity.class);
                i.putExtra("tabel", "tabel_icon_kabupaten");
                startActivity(i);
            }
        });
        card_kabupaten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminActivity.this, AdminShowTableActivity.class);
                i.putExtra("tabel", "tabel_kabupaten");
                startActivity(i);
            }
        });
        card_kuliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminActivity.this, AdminShowTableActivity.class);
                i.putExtra("tabel", "tabel_kuliner");
                startActivity(i);
            }
        });
        card_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminActivity.this, AdminShowTableActivity.class);
                i.putExtra("tabel", "tabel_link");
                startActivity(i);
            }
        });
        card_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminActivity.this, AdminShowTableActivity.class);
                i.putExtra("tabel", "tabel_user");
                startActivity(i);
            }
        });
        card_wisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminActivity.this, AdminShowTableActivity.class);
                i.putExtra("tabel", "tabel_wisata");
                startActivity(i);
            }
        });
    }
}
