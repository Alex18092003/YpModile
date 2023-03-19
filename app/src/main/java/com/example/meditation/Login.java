package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

        SharedPreferences prefs = this.getSharedPreferences(
                "Date", Context.MODE_PRIVATE);
        if(prefs != null)
        {
            Email.setText(prefs.getString("Email", ""));
            Password.requestFocus();
        }

    }

    public  void TransitionToRegistration(View v)
    {
        startActivity(new Intent(this, Register.class));

    }
    public Boolean  Proverka()
    {
        Pattern pattern = Pattern.compile("@", Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(Email.getText().toString());
        boolean b = m.find();
        return b;
    }

    public void Entrance(View v)
    {
        if(Email.getText().toString().equals("") || Password.getText().toString().equals(""))
        {
            Toast.makeText(Login.this, "Обязательные поля не заполнены", Toast.LENGTH_SHORT).show();
        }
        else {
            boolean b = Proverka();
            if(b) {
                postData();
            }
            else {
                Toast.makeText(Login.this, "Поле для Email должно содержать '@'", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public  void TransitionToMain(View v)
    {
        startActivity(new Intent(Login.this, Main.class));

    }
    public static String Avatar;
    public static String NickName;
    private void postData() {
        String email = String.valueOf(Email.getText());
        String password = String.valueOf(Password.getText());

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
                if (!response.isSuccessful()) {
                    Toast.makeText(Login.this, "Пользователь не найден", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(response.body() != null) {
                    if(response.body().getToken() != null) {
                        SharedPreferences prefs = getSharedPreferences( // Сохранение данных
                                "Date", Context.MODE_PRIVATE);
                        prefs.edit().putString("Email", "" + email).apply();
                        prefs.edit().putString("Avatar", "" + response.body().getAvatarBitmap()).apply();
                        prefs.edit().putString("NickName", "" + response.body().getNickName()).apply();

                        Main.CurrentUser = response.body();
                        startActivity(new Intent(Login.this, Main.class));
                    }
                }
            }

            @Override
            public void onFailure(Call<MaskUser> call, Throwable t) {
                Toast.makeText(Login.this, "Ошибка: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}