package com.irwantostudio.wonderfuljateng.mData;

/**
 * Created by Oclemmy on 4/25/2016 for ProgrammingWizards Channel.
 */
public class DataWisata {

    String nama_wisata, deskripsi_wisata, nama_kabupaten, url_image;

    public DataWisata() {
    }

    public String getNamaWisata() {
        return nama_wisata;
    }
    public void setNamaWisata(String name) {
        this.nama_wisata = name;
    }

    public String getDeskripsiWisata() {
        return deskripsi_wisata;
    }
    public void setDeskripsiWisata(String name) {
        this.deskripsi_wisata = name;
    }

    public String getNamaKabupaten() {
        return nama_kabupaten;
    }
    public void setNamaKabupaten(String name) {
        this.nama_kabupaten = name;
    }

    public String getUrlImage() {
        return url_image;
    }
    public void setUrlImage(String url) {
        this.url_image = url;
    }
}
