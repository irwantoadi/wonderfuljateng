package com.irwantostudio.wonderfuljateng;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    ImageButton btn_kuliner, btn_penginapan, btn_umkm, btn_wisata, btn_profile, btn_budaya;

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getBundleExtra("emailpass");
        String email = bundle.getString("email");
        String password = bundle.getString("pass");

        auth = FirebaseAuth.getInstance();
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerToggle.syncState();

//        TextView tvUser = findViewById(R.id.hello);
//        tvUser.setText(email+" "+password);

        ImageSlider imageSlider = findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(getString(R.string.url1), ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://blog.airyrooms.com/wp-content/uploads/2018/07/800X500-3.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://tempatwisataseru.com/wp-content/uploads/2015/11/Dieng.jpg", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        btn_wisata = findViewById(R.id.btn_wisata);
        btn_kuliner = findViewById(R.id.btn_kuliner);
        btn_penginapan = findViewById(R.id.btn_penginapan);
        btn_budaya = findViewById(R.id.btn_budaya);
        btn_profile = findViewById(R.id.btn_profil);
        btn_umkm = findViewById(R.id.btn_umkm);

        btn_wisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(MainActivity.this, WisataActivity.class);
                startActivity(home);
            }
        });
    }

    public String getURLForResource (int resourceId) {
        //use BuildConfig.APPLICATION_ID instead of R.class.getPackage().getName() if both are not same
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        auth.signOut();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
//            super.onBackPressed();
            myAlert(MainActivity.this);
        }
    }

    private void myAlert(Context context) {
        new AlertDialog.Builder(context)
                .setTitle("Keluar?")
                .setMessage("Apakah yakin akan keluar aplikasi?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        intent.putExtra("Exit me", true);
//                        startActivity(intent);
                        finish();
                        System.exit(0);
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_akun:
                // Do whatever you want to do on click.
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
