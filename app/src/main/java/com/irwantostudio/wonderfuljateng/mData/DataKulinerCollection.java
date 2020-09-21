package com.irwantostudio.wonderfuljateng.mData;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.irwantostudio.wonderfuljateng.R;
import com.irwantostudio.wonderfuljateng.ShowKulinerActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Oclemmy on 4/25/2016 for ProgrammingWizards Channel.
 */
public class DataKulinerCollection {


    public static ArrayList<DataKuliner> getDataKuliner() throws JSONException, IOException {

        //ADDING DATA
//        tv.setName("BlackList");
//        tv.setUrl("http://res.cloudinary.com/oclemy/image/upload/v1460355636/red_s9jrzj.jpg");
//        tvshows.add(tv);

        //creating a URL
        URL url = new URL("https://sipetik.com/server/select_kuliner.php");

        //Opening the URL using HttpURLConnection
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        //StringBuilder object to read the string from the service
        StringBuilder sb = new StringBuilder();

        //We will use a buffered reader to read the string from service
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

        //A simple string to read values from each line
        String json;

        //reading until we don't find null
        while ((json = bufferedReader.readLine()) != null) {

            //appending it to string builder
            sb.append(json + "\n");
        }

        //finally returning the read string
        json = sb.toString().trim();

        //creating a json array from the json string
        JSONArray jsonArray = new JSONArray(json);
        final String[] id_kuliner = new String[jsonArray.length()];

        ArrayList<DataKuliner> dataKuliner=new ArrayList<>();
        DataKuliner data=new DataKuliner();

        //looping through all the elements in json array
        for (int i = 0; i < jsonArray.length(); i++) {

            //getting json object from the json array
            JSONObject obj = jsonArray.getJSONObject(i);
            //getting the name from the json object and putting it inside string array

            data.setNamaKuliner(obj.getString("nama_kuliner"));
            data.setDeskripsiKuliner(obj.getString("ket_kuliner").substring(0, 40)+"....");
            data.setNamaKabupaten(obj.getString("nama_kabupaten"));
            data.setUrlImage(obj.getString("url_image"));
            id_kuliner[i] = obj.getString("id_kuliner");
            dataKuliner.add(data);
        }

        return dataKuliner;
    }
}
