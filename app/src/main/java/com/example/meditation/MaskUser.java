package com.example.meditation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.Serializable;

public class MaskUser  {

    private String id;
    private String email;
    private String nickName;
    private Bitmap avatarBitmap;
    private String token;
    private String avatar;
    private String password;

    MaskUser(String id, String email, String nickName, String avatar, String token) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        new DownloadImageTask()
                .execute(avatar);
        this.token = token;
    }

    MaskUser(String email, String password) {
        this.email = email;
        this.password = password;

    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Bitmap getAvatarBitmap() {
        new DownloadImageTask()
                .execute(avatar);
        return avatarBitmap;
    }

    public void setAvatarBitmap(String avatarPath) {
        new DownloadImageTask()
                .execute(avatar);
    }


    public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {


        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Ошибка передачи изображения", e.getMessage());
                e.printStackTrace();
            }
            avatarBitmap = mIcon11;
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            avatarBitmap = result;
        }
    }
}
