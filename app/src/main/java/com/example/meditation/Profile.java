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


//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
//                photoPickerIntent.setType("image/*");
//               // someActivityResultLauncher.launch(photoPickerIntent);
//            }
//        });
    }


        //https://stackoverflow.com/questions/8664440/how-to-copy-image-file-from-gallery-to-another-folder-programmatically-in-androi
        //https://www.google.com/search?q=how+copy+image+from+gallery+to+program+android+studio&rlz=1C1GCEA_enRU1047RU1047&biw=1920&bih=969&sxsrf=AJOqlzXVic10khtO0ldr8UyMSZZVxQsljg%3A1678096945983&ei=MboFZMfdO4iNrwTLqZPwDQ&oq=how+copy+image+from+galary+to+progra&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAxgAMgcIIRCgARAKMgcIIRCgARAKMgYIIRAVEAoyCgghEBYQHhAdEAoyCgghEBYQHhAdEAo6CggAEEcQ1gQQsAM6BQgAEIAEOgwIABANEIAEEEYQ_wE6BwgAEA0QgAQ6BwguEA0QgAQ6BggAEBYQHjoECCMQJzoKCAAQgAQQFBCHAjoICAAQgAQQsQM6BQguEIAEOg8IABCABBAUEIcCEEYQ_wE6EQgAEA0QgAQQFBCHAhBGEP8BOgwIABANEIAEEBQQhwI6CAgAEBYQHhAPOgcIABCABBANOggIABAIEB4QDToICAAQFhAeEAo6BwgAEIAEEBM6BQghEKABOggIIRAWEB4QHToLCCEQFhAeEPEEEB06CgghEBYQHhAPEB06BAghEBVKBAhBGABQ2ClYtpICYJ-tAmgYcAF4AIABbYgB-xySAQQ1MS4ymAEAoAEByAEIwAEB&sclient=gws-wiz-serp&safe=active&ssui=on

//    @Override
//    public void onActivityResult(ActivityResult result) {
//        Bitmap bitmap = null;
//        if (result.getResultCode() == Activity.RESULT_OK) {
//            Uri selectedImage = result.getData().getData();
//            try {
//                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }

    public void fhfh() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        //someActivityResultLauncher.launch(photoPickerIntent);
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