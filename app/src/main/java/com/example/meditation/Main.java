package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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