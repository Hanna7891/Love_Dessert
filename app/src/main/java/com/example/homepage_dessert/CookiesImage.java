package com.example.homepage_dessert;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CookiesImage extends BaseAdapter {

    private Context mContext;
    public Integer [] thumbImages =
            {
                    R.drawable.cis_1, R.drawable.cis_2, R.drawable.cis_3,
                    R.drawable.cis_4, R.drawable.cis_5, R.drawable.cis_6,
                    R.drawable.cis_7, R.drawable.cis_8, R.drawable.cis_9,
                    R.drawable.cis_10, R.drawable.cis_11, R.drawable.cis_12,
                    R.drawable.cis_13, R.drawable.cis_13, R.drawable.cis_15,
                    R.drawable.cis_16, R.drawable.cis_17, R.drawable.cis_18,
            };
    public CookiesImage(Context c){ mContext = c; }

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
