package com.example.meditation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.util.List;

public class AdapterFeelings extends
        RecyclerView.Adapter<AdapterFeelings.ViewHolder> {

    private List<MaskFeeling> maskList;
    private Context mContext;

    public AdapterFeelings(Context mContext, List<MaskFeeling> maskList)
    {
        this.mContext = mContext;
        this.maskList = maskList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView image;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            image = (ImageView) view.findViewById(R.id.image);
        }
    }




    @Override
    public int getItemCount() {
       return maskList.size();
    }


    @NonNull
    @Override
    public AdapterFeelings.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new AdapterFeelings.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.mask, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull AdapterFeelings.ViewHolder holder, int position) {

       final MaskFeeling c = maskList.get(position);
        holder.title.setText(c.getTitle());

        if(c.getImage().equals("null"))
        {
            holder.image.setImageResource(R.drawable.rect);
        }
        else
        {
            new AdapterFeelings.DownloadImageTask((ImageView) holder.image)
                    .execute(c.getImage());
        }

        //holder.image.setImageResource(String.valueOf(c.getImage()));
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
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
