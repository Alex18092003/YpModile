package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    EditText Email, Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
    }

    public  void TransitionToRegistration(View v)
    {
        startActivity(new Intent(this, Register.class));

    }

    public void Entrance(View v)
    {
        if(Email.getText().toString().equals("") || Password.getText().toString().equals(""))
        {
            Toast.makeText(Login.this, "Обязательные поля не заполнены", Toast.LENGTH_SHORT).show();
        }
        else {
            Pattern pattern = Pattern.compile("@", Pattern.CASE_INSENSITIVE);
            Matcher m = pattern.matcher(Email.getText().toString());
            boolean b = m.find();
            if(b == true) {
                postData();
            }
            else {
                Toast.makeText(Login.this, "Поле для Email должно содержать '@'", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public  void TransitionToMain(View v)
    {
        startActivity(new Intent(this, Main.class));

    }

    private void postData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mskko2021.mad.hakta.pro/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        SendUser sendUser = new SendUser(Email.getText().toString(), Password.getText().toString());
        retrofit2.Call<MaskUser> call = retrofitAPI.createUser(sendUser);
        call.enqueue(new Callback<MaskUser>() {
            @Override
            public void onResponse(Call<MaskUser> call, Response<MaskUser> response) {
                Main.CurrentUser = response.body();
                startActivity(new Intent(Login.this, Main.class));
            }

            @Override
            public void onFailure(Call<MaskUser> call, Throwable t) {
                Toast.makeText(Login.this, "Ошибка: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}