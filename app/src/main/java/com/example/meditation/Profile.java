package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView Nik = findViewById(R.id.txt);
        Nik.setText(Main.CurrentUser.getNickName());
        ImageView avatar = findViewById(R.id.imageView33);

        avatar.setImageBitmap(Main.CurrentUser.getAvatarBitmap());
    }


    public  void TransitionToMenu(View v)
    {
        startActivity(new Intent(this, Menu.class));

    }

    public  void TransitionToLogin(View v)
    {
        SharedPreferences prefs = getSharedPreferences(
                "Date", Context.MODE_PRIVATE);
        prefs.edit().putString("Avatar", "").apply();
        prefs.edit().putString("NickName", "").apply();
        startActivity(new Intent(this, Login.class));

    }
}