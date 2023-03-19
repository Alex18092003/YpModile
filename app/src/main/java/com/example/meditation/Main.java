package com.example.meditation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.auth.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main extends AppCompatActivity {

    public static MaskUser CurrentUser;
    private AdapterQuote adapterQuote;
    private List<MaskQuote> maskQuoteList = new ArrayList<>();

    private AdapterFeelings adapterFeelings;
    private List<MaskFeeling> maskFeelingList = new ArrayList<>();

    final static String userVariableKey = "USER_VARIABLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView lvProduct = findViewById(R.id.ListQuotes);
        adapterQuote = new AdapterQuote(Main.this, maskQuoteList);
        lvProduct.setAdapter(adapterQuote);

        RecyclerView lvProduct2 = findViewById(R.id.ListFeelings);
        lvProduct2.setHasFixedSize(true);
        lvProduct2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterFeelings = new AdapterFeelings(Main.this, maskFeelingList);
        lvProduct2.setAdapter(adapterFeelings);

        ImageView ava = findViewById(R.id.ava);
        ava.setImageBitmap(CurrentUser.getAvatarBitmap());

        TextView textHello = findViewById(R.id.textHello);
        textHello.setText("С возвращением, " + CurrentUser.getNickName() + "!");
        //textHello.setText(textHello.getText().toString() + Login.NickName + "!");
        new GetFeeling().execute();
        new GetQuote().execute();


    }


    private class GetQuote extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("http://mskko2021.mad.hakta.pro/api/quotes");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                return result.toString();
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                maskQuoteList.clear();
                adapterQuote.notifyDataSetInvalidated();

                JSONObject object = new JSONObject(s);
                JSONArray tempArray = object.getJSONArray("data");

                for (int i = 0; i < tempArray.length(); i++) {
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
            } catch (Exception exception) {
                Toast.makeText(Main.this, "Что-то пошло не так с выводом данных", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void TransitionToMenu(View v) {
        startActivity(new Intent(this, Menu.class));

    }

    public void TransitionToProfile(View v) {
        startActivity(new Intent(this, Profile.class));

    }

    private class GetFeeling extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("http://mskko2021.mad.hakta.pro/api/feelings");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                return result.toString();
            } catch (Exception exception) {
                return null;
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                maskFeelingList.clear();
                adapterFeelings.notifyDataSetChanged();

                JSONObject object = new JSONObject(s);
                JSONArray tempArray = object.getJSONArray("data");

                for (int i = 0; i < tempArray.length(); i++) {
                    JSONObject productJson = tempArray.getJSONObject(i);
                    MaskFeeling tempProduct = new MaskFeeling(
                            productJson.getInt("id"),
                            productJson.getString("title"),

                            productJson.getInt("position"),
                            productJson.getString("image")
                    );
                    maskFeelingList.add(tempProduct);
                    adapterFeelings.notifyDataSetChanged();
                }
                maskFeelingList.sort(Comparator.comparing(MaskFeeling::getPosition));
                adapterFeelings.notifyDataSetChanged();
            } catch (Exception exception) {
                Toast.makeText(Main.this, "При выводе данных возникла ошибка", Toast.LENGTH_SHORT).show();
            }
        }
    }

     //получение ранее сохраненного состояния
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        CurrentUser= (MaskUser) savedInstanceState.get(userVariableKey);

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putAll(outState);
        super.onSaveInstanceState(outState);
    }
}
