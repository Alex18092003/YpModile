package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Photo extends AppCompatActivity {


    View touch;
    ImageView imageView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        imageView4 = findViewById(R.id.imageView4);
        touch = findViewById(R.id.touch);
        //Свайпы на фото
        imageView4.setOnTouchListener(new OnSwipeTouchListener(Photo.this) {
            public void onSwipeRight() {
                startActivity(new Intent(Photo.this, Profile.class));
            }

            public void onSwipeLeft() {
                try {
                    Toast.makeText(Photo.this, "Фотография успешно удалена", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Photo.this, Profile.class));
                } catch (Exception e) {
                    Toast.makeText(Photo.this, "При удаление фотографии возникла ошибка!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Свайпы на ConstraintLayout
        touch.setOnTouchListener(new OnSwipeTouchListener(Photo.this) {
            public void onSwipeRight() {
                startActivity(new Intent(Photo.this, Profile.class));
            }

            public void onSwipeLeft() {
                try {
                    Toast.makeText(Photo.this, "Фотография успешно удалена", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Photo.this, Profile.class));
                } catch (Exception e) {
                    Toast.makeText(Photo.this, "При удаление фотографии возникла ошибка!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public  void TransitionToLogin(View v)
    {
        startActivity(new Intent(this, Profile.class));

    }
}