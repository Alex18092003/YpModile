package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class Onboarding extends AppCompatActivity {

    public static String Avatar;
    public static String NickName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
    }

    public void TransitionToEntrance(View v) {
        startActivity(new Intent(this, Login.class));

    }

    public void TransitionToRegistration(View v) {
        startActivity(new Intent(this, Register.class));

    }
}