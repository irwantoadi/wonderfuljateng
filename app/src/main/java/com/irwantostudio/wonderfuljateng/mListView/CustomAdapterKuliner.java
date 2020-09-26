package com.irwantostudio.wonderfuljateng.mListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.irwantostudio.wonderfuljateng.R;
import com.irwantostudio.wonderfuljateng.mData.DataKuliner;
import com.irwantostudio.wonderfuljateng.mPicasso.PicassoClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Oclemmy on 4/25/2016 for ProgrammingWizards Channel.
 */
public class CustomAdapterKuliner extends BaseAdapter {

    Context c;
    ArrayList<DataKuliner> dataKuliner;
    LayoutInflater inflater;

    public CustomAdapterKuliner(Context c, ArrayList<DataKuliner> dataKuliner) {
        this.c = c;
        this.dataKuliner = dataKuliner;
    }

    @Override
    public int getCount() {
        return dataKuliner.size();
    }

    @Override
    public Object getItem(int position) {
        return dataKuliner.get(position);
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
            convertView=inflater.inflate(R.layout.list_kuliner_row,parent,false);

        }

        //BIND DATA
        MyHolderKuliner holder=new MyHolderKuliner(convertView);
        holder.nama_kuliner.setText(dataKuliner.get(position).getNamaKuliner());
        holder.deskripsi_kuliner.setText(dataKuliner.get(position).getDeskripsiKuliner());
        holder.lokasi_kuliner.setText(dataKuliner.get(position).getNamaKabupaten());
//        PicassoClient.downloadImage(c,dataKuliner.get(position).getUrlImage(),holder.img_kuliner);
        Picasso.get().load(dataKuliner.get(position).getUrlImage()).into(holder.img_kuliner);

        return convertView;
    }
}
