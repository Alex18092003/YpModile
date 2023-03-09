package com.example.meditation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

public class AdapterQuote extends BaseAdapter {

    private Context mContext;
    private List<MaskQuote> maskList;

    public AdapterQuote(Context mContext, List<MaskQuote> maskList) {
        this.mContext = mContext;
        this.maskList = maskList;
    }

    @Override
    public int getCount() {
        return maskList.size();
    }

    @Override
    public Object getItem(int position) {
        return maskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return maskList.get(position).getId();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.masktwo, null);

        TextView title = v.findViewById(R.id.title);
        TextView description = v.findViewById(R.id.description);
        ImageView Image = v.findViewById(R.id.image);

        MaskQuote maskQuote = maskList.get(position);
        title.setText(maskQuote.getTitle());
        description.setText(maskQuote.getDescription());
        if (maskQuote.getImage().equals("null")) {
            Image.setImageResource(R.drawable.rect);
        } else {
            new DownloadImageTask((ImageView) Image).execute(maskQuote.getImage());
        }

        //Image.setImageBitmap(getUserImage(maskQuote.getImage()));
        return v;
    }

    public static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }

    }
}