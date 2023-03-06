package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {


    private AdapterFeelings adapterFeelings;
    private  AdapterQuote adapterQuote;
    private List<MaskFeeling> maskFeelingList = new ArrayList<>();
    private List<MaskQuote> maskQuoteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView lvProduct = findViewById(R.id.ListQuotes);
        adapterQuote = new AdapterQuote(Main.this, maskQuoteList);
        lvProduct.setAdapter(adapterQuote);

        new GetQuote().execute();
    }

    private  class GetQuote extends AsyncTask<Void, Void, String>
    {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("mskko2021.mad.hakta.pro/api");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String line = "";
                while ((line = reader.readLine())!= null)
                {
                    result.append(line);
                }
                return  result.toString();
            } catch (Exception e) {
                return  null;
            }
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            try {
                maskQuoteList.clear();
                adapterQuote.notifyDataSetInvalidated();

                JSONObject object = new JSONObject(s);
                JSONArray tempArray = object.getJSONArray("data");

                for (int i = 0; i < tempArray.length(); i++)
                {
                    JSONObject productJSON = tempArray.getJSONObject(i);
                    MaskQuote tempProduct = new MaskQuote(
                      productJSON.getInt("id"),
                            productJSON.getString("title"),
                            productJSON.getString("image"),
                            productJSON.getString("description")
                    );
                    maskQuoteList.add(tempProduct);
                    adapterQuote.notifyDataSetInvalidated();

                }
            }
            catch (Exception exception)
            {
                Toast.makeText(Main.this, "Что-то пошло не так с выводом данных", Toast.LENGTH_LONG).show();
            }
        }
    }

    public  void TransitionToMenu(View v)
    {
        startActivity(new Intent(this, Menu.class));

    }

    public  void TransitionToProfile(View v)
    {
        startActivity(new Intent(this, Profile.class));

    }
}