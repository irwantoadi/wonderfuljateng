package com.irwantostudio.wonderfuljateng.mListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.irwantostudio.wonderfuljateng.R;
import com.irwantostudio.wonderfuljateng.mData.DataWisata;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Oclemmy on 4/25/2016 for ProgrammingWizards Channel.
 */
public class CustomAdapterWisata extends BaseAdapter {

    Context c;
    ArrayList<DataWisata> dataWisata;
    LayoutInflater inflater;

    public CustomAdapterWisata(Context c, ArrayList<DataWisata> dataWisata) {
        this.c = c;
        this.dataWisata = dataWisata;
    }

    @Override
    public int getCount() {
        return dataWisata.size();
    }

    @Override
    public Object getItem(int position) {
        return dataWisata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.list_wisata_row,parent,false);

        }

        //BIND DATA
        MyHolderWisata holder=new MyHolderWisata(convertView);
        holder.nama_wisata.setText(dataWisata.get(position).getNamaWisata());
        holder.deskripsi_wisata.setText(dataWisata.get(position).getDeskripsiWisata());
        holder.lokasi_wisata.setText(dataWisata.get(position).getNamaKabupaten());
//        PicassoClient.downloadImage(c,dataKuliner.get(position).getUrlImage(),holder.img_kuliner);
        Picasso.get().load(dataWisata.get(position).getUrlImage()).into(holder.img_wisata);

        return convertView;
    }
}
