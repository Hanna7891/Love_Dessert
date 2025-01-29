package com.example.homepage_dessert;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MacImageAdapter extends BaseAdapter {

    private Context mContext;
    public Integer [] thumbImages =
            {
                    R.drawable.mac_1, R.drawable.mac_2, R.drawable.mac_3,
                    R.drawable.mac_4, R.drawable.mac_5, R.drawable.mac_6,
                    R.drawable.mac_7, R.drawable.mac_8, R.drawable.mac_9,
                    R.drawable.mac_10, R.drawable.mac_11, R.drawable.mac_12,
                    R.drawable.mac_13, R.drawable.mac_14, R.drawable.mac_15,
                    R.drawable.mac_16, R.drawable.mac_17, R.drawable.mac_18,
            };
    public MacImageAdapter(Context c){ mContext = c; }

    @Override
    public int getCount(){ return thumbImages.length; }

    @Override
    public Object getItem(int position){ return thumbImages[position]; }

    @Override
    public long getItemId(int position){ return 0; }
    @Override
    public View getView(int position, View conventView, ViewGroup parent)
    {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new ViewGroup.LayoutParams (320, 320));
        imageView.setScaleType (ImageView. ScaleType. CENTER_CROP);
        imageView.setPadding(8,8,8,8);
        imageView.setImageResource(thumbImages[position]);
        return imageView;
    }
}
