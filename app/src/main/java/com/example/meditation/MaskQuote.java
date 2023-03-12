package com.example.meditation;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class MaskQuote implements Parcelable {

    private  int id;
    private  String title;
    private String image;
    private  String description;

    public static final Creator<MaskQuote> CREATOR = new Creator<MaskQuote>() {
        @Override
        public MaskQuote createFromParcel(Parcel in) {
            return new MaskQuote(in);
        }

        @Override
        public MaskQuote[] newArray(int size) {
            return new MaskQuote[size];
        }
    };

    public MaskQuote(int id, String title, String image, String description) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
    }

    protected MaskQuote(Parcel in) {
        id = in.readInt();
        title = in.readString();
        image = in.readString();
        description = in.readString();
    }

    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }



    public void setTitle(String title) {
        this.title = title;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(image);
        dest.writeString(description);
    }
}
