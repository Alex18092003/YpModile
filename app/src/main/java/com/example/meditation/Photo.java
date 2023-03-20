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

    float x, y;
    String sDown, sMove, sUp;
    ConstraintLayout toush = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        toush = findViewById(R.id.toush);
        toush.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_MOVE)
                {
                   // startActivity(new Intent(this,Login.class));
                    Intent i = new Intent(Photo.this, Profile.class);
                    startActivity(i);
                }
//                switch (event.getAction())
//                {
//                    case  MotionEvent.ACTION_MOVE:
//                        startActivity(new Intent(this,
//                                Login.class));
//                        break;
//                    default:
//                        break;
//                }

                return false;
            }
        });
    }

    public  void TransitionToLogin(View v)
    {
       // startActivity(new Intent(this, Login.class));

    }

//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//      x = event.getX();
//      y = event.getY();
//      switch (event.getAction())
//      {
//          case MotionEvent.ACTION_DOWN:
//              break;
//              case  MotionEvent.ACTION_MOVE:
//                  startActivity(new Intent(this, Login.class));
//                  break;
//      }
//      return  true;
//    }
}