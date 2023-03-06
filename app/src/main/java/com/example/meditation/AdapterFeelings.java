package com.example.meditation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterFeelings extends
        RecyclerView.Adapter<AdapterFeelings.MyViewHolder> {

    private List<MaskFeeling> maskList;
    private Context mContext;

    public AdapterFeelings(Context mContext, List<MaskFeeling> maskList)
    {
        this.mContext = mContext;
        this.maskList = maskList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            image = (ImageView) view.findViewById(R.id.image);
        }
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        MaskFeeling c = maskList.get(position);
        holder.title.setText(c.getTitle());


        //holder.image.setImageResource(String.valueOf(c.getImage()));
    }

    @Override
    public int getItemCount() {
       return maskList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mask,parent, false);
        return new MyViewHolder(v);
    }

}
