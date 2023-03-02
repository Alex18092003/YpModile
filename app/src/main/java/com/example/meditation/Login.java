package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public  void TransitionToRegistration(View v)
    {
        startActivity(new Intent(this, Register.class));

    }

    public  void TransitionToMain(View v)
    {
        startActivity(new Intent(this, Main.class));

    }
}