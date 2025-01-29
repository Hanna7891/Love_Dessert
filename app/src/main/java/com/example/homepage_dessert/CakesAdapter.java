package com.example.homepage_dessert;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CakesAdapter extends BaseAdapter {
    private Context mContext;
    public Integer [] thumbImages =
            {
                    R.drawable.cakes_1, R.drawable.cakes_2, R.drawable.cakes_3,
                    R.drawable.cakes_4, R.drawable.cakes_5, R.drawable.cakes_6,
                    R.drawable.cakes_7, R.drawable.cakes_8, R.drawable.cakes_9,
                    R.drawable.cakes_10, R.drawable.cakes_11, R.drawable.cakes_12,
                    R.drawable.cakes_13, R.drawable.cakes_14, R.drawable.cakes_15,
                    R.drawable.cakes_16, R.drawable.cakes_17, R.drawable.cakes_18,
            };
    public CakesAdapter(Context c){ mContext = c; }

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

