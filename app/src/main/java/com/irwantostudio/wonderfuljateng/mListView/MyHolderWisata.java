package com.irwantostudio.wonderfuljateng.mListView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.irwantostudio.wonderfuljateng.R;

/**
 * Created by Oclemmy on 4/25/2016 for ProgrammingWizards Channel.
 */
public class MyHolderWisata {

    TextView nama_wisata, deskripsi_wisata, lokasi_wisata;
    ImageView img_wisata;

    public MyHolderWisata(View v) {

        nama_wisata= (TextView) v.findViewById(R.id.nama_wisata);
        deskripsi_wisata = (TextView) v.findViewById(R.id.deskripsi_wisata);
        lokasi_wisata = (TextView) v.findViewById(R.id.lokasi_wisata);
        img_wisata= (ImageView) v.findViewById(R.id.id_image_wisata);

    }
}
