package com.irwantostudio.wonderfuljateng;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ShowWisataActivity extends AppCompatActivity {

    private AdView mAdView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_wisata);
        setTitle("Curug Pitu Banjarnegara");

//        imageView = findViewById(R.id.id_show_wisata);
//        Picasso.get().load("https://sipetik.com/server/select_image_wisata.php?id=7").into(imageView);


        ImageSlider imageSlider = findViewById(R.id.image_show_wisata_slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(getString(R.string.url1), ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://blog.airyrooms.com/wp-content/uploads/2018/07/800X500-3.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://tempatwisataseru.com/wp-content/uploads/2015/11/Dieng.jpg", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        //script admob
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
//                Toast.makeText(getApplicationContext(),
//                        "ad finish loading", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
//                Toast.makeText(getApplicationContext(),
//                        "ad request fail", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
//                Toast.makeText(getApplicationContext(),
//                        "ad finish opened overlay", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
    }
}
