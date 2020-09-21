package com.irwantostudio.wonderfuljateng.mListView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.irwantostudio.wonderfuljateng.R;

/**
 * Created by Oclemmy on 4/25/2016 for ProgrammingWizards Channel.
 */
public class MyHolderKuliner {

    TextView nama_kuliner, deskripsi_kuliner, lokasi_kuliner;
    ImageView img_kuliner;

    public MyHolderKuliner(View v) {

        nama_kuliner= (TextView) v.findViewById(R.id.nama_kuliner);
        deskripsi_kuliner = (TextView) v.findViewById(R.id.deskripsi_kuliner);
        lokasi_kuliner = (TextView) v.findViewById(R.id.lokasi_kuliner);
        img_kuliner= (ImageView) v.findViewById(R.id.id_image_kuliner);

    }
}
