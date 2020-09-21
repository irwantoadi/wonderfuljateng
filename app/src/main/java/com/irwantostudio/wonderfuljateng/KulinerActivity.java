package com.irwantostudio.wonderfuljateng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.irwantostudio.wonderfuljateng.mData.DataKuliner;
import com.irwantostudio.wonderfuljateng.mData.DataKulinerCollection;
import com.irwantostudio.wonderfuljateng.mListView.CustomAdapterKuliner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class KulinerActivity extends AppCompatActivity {
    ListView listView;
    private HashMap<String, String> item;
    private AdView mAdView;
    CustomAdapterKuliner adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliner);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        listView = (ListView) findViewById(R.id.list_view);

        getJSON("https://sipetik.com/server/select_kuliner.php");

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_wisata_row, R.id.nama_wisata, countryList);

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

    private void loadIntoListView(String json) throws JSONException {
        //creating a json array from the json string
        JSONArray jsonArray = new JSONArray(json);
        final String[] id_kuliner = new String[jsonArray.length()];


        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();

        ArrayList<DataKuliner> dataKuliner=new ArrayList<>();

        //looping through all the elements in json array
        for (int i = 0; i < jsonArray.length(); i++) {

            DataKuliner data=new DataKuliner();
            //getting json object from the json array
            JSONObject obj = jsonArray.getJSONObject(i);
            //getting the name from the json object and putting it inside string array

            data.setNamaKuliner(obj.getString("nama_kuliner"));
            data.setDeskripsiKuliner(obj.getString("ket_kuliner").substring(0, 40)+"....");
            data.setNamaKabupaten(obj.getString("nama_kabupaten"));
            data.setUrlImage("");
            id_kuliner[i] = obj.getString("id_kuliner");
            dataKuliner.add(data);
        }

//        return dataKuliner;

        //looping through all the elements in json array
//        for (int i = 0; i < jsonArray.length(); i++) {
//
//            //getting json object from the json array
//            JSONObject obj = jsonArray.getJSONObject(i);
//            //getting the name from the json object and putting it inside string array
////            nama_wisata[i] = obj.getString("nama_wisata");
////            deskripsi_wisata[i] = obj.getString("ket_wisata").substring(0, 48);
//
//            item = new HashMap<String,String>();
//            item.put( "line1", obj.getString("nama_kuliner"));
//            item.put( "line2", obj.getString("ket_kuliner").substring(0, 40)+"....");
//            item.put( "line3", obj.getString("nama_kabupaten"));
//            item.put( "line4", obj.getString("id_kuliner"));
//            item.put( "line5", obj.getString("url_image"));
//            id_kuliner[i] = obj.getString("id_kuliner");
//            wordList.add( item );
//        }

        //the array adapter to load data into list
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_wisata_row, R.id.nama_wisata, nama_wisata);
//        SimpleAdapter arrayAdapter1 = new SimpleAdapter(this, wordList,
//                R.layout.list_kuliner_row,
//                new String[] { "line1","line2", "line3"},
//                new int[] {R.id.nama_kuliner, R.id.deskripsi_kuliner, R.id.lokasi_kuliner});

        //attaching adapter to listview
//        listView.setAdapter(arrayAdapter);

        adapter=new CustomAdapterKuliner(this, dataKuliner);
        listView.setAdapter(adapter);
        listView.setDivider(null);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ShowKulinerActivity.class);
                intent.putExtra("id_kuliner",id_kuliner[i]);
                startActivity(intent);
            }
        });
    }

    //this method is actually fetching the json string
    private void getJSON(final String urlWebService) {
        /*
         * As fetching the json string is a network operation
         * And we cannot perform a network operation in main thread
         * so we need an AsyncTask
         * The constrains defined here are
         * Void -> We are not passing anything
         * Void -> Nothing at progress update as well
         * String -> After completion it should return a string and it will be the json string
         * */
        class GetJSON extends AsyncTask<Void, Void, String> {

            //this method will be called before execution
            //you can display a progress bar or something
            //so that user can understand that he should wait
            //as network operation may take some time
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            //this method will be called after execution
            //so here we are displaying a toast with the json string
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
//                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            //in this method we are fetching the json string
            @Override
            protected String doInBackground(Void... voids) {



                try {
                    //creating a URL
                    URL url = new URL(urlWebService);

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
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }

        //creating asynctask object and executing it
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }
}
