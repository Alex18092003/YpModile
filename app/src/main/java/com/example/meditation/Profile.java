package com.example.meditation;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

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





    public void TransitionToMenu(View v) {
        startActivity(new Intent(this, Menu.class));

    }

    public void TransitionToLogin(View v) {
        SharedPreferences prefs = getSharedPreferences(
                "Date", Context.MODE_PRIVATE);
        prefs.edit().putString("Avatar", "").apply();
        prefs.edit().putString("NickName", "").apply();
        startActivity(new Intent(this, Login.class));
    }


    public void TransitionToPhoto(View v) {
        startActivity(new Intent(this, Photo.class));

    }


}