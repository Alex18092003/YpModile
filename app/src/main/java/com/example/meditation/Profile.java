package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public  void TransitionToMenu(View v)
    {
        startActivity(new Intent(this, Menu.class));

    }

    public  void TransitionToLogin(View v)
    {
        startActivity(new Intent(this, Login.class));

    }
}