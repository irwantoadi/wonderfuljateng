package com.irwantostudio.wonderfuljateng.mData;

/**
 * Created by Oclemmy on 4/25/2016 for ProgrammingWizards Channel.
 */
public class DataKuliner {

    String nama_kuliner, deskripsi_kuliner, nama_kabupaten, url_image;

    public DataKuliner() {
    }

    public String getNamaKuliner() {
        return nama_kuliner;
    }
    public void setNamaKuliner(String name) {
        this.nama_kuliner = name;
    }

    public String getDeskripsiKuliner() {
        return deskripsi_kuliner;
    }
    public void setDeskripsiKuliner(String name) {
        this.deskripsi_kuliner = name;
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
