package com.example.meditation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterQuote extends BaseAdapter  {

    private  Context mContext;
    private List<MaskQuote> maskList;

    public AdapterQuote(Context mContext, List<MaskQuote> maskList)
    {
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

    public Bitmap getUserImage(String encodedImg)
    {
        if(encodedImg!=null&& !encodedImg.equals("null")) {
            byte[] bytes = Base64.decode(encodedImg, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        else
        {
            return BitmapFactory.decodeResource(mContext.getResources(), R.drawable.calm);

        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.masktwo, null);

        TextView title = v.findViewById(R.id.title);
        TextView description = v.findViewById(R.id.description);
        //ImageView Image = v.findViewById(R.id.image);

        MaskQuote maskQuote = maskList.get(position);
        title.setText(maskQuote.getTitle());
        description.setText(maskQuote.getDescription());

        //Image.setImageBitmap(getUserImage(maskQuote.getImage()));
        return  v;
    }
}
