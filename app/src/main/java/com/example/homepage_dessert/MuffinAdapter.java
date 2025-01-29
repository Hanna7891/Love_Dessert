package com.example.homepage_dessert;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MuffinAdapter extends BaseAdapter {

    private Context mContext;
    public Integer [] thumbImages =
            {
                    R.drawable.muf_1, R.drawable.muf_2, R.drawable.muf_3,
                    R.drawable.muf_4, R.drawable.muf_5, R.drawable.muf_6,
                    R.drawable.muf_7, R.drawable.muf_8, R.drawable.muf_9,
                    R.drawable.muf_10, R.drawable.muf_11, R.drawable.muf_12,
                    R.drawable.muf_13, R.drawable.muf_14, R.drawable.muf_15,
                    R.drawable.muf_16, R.drawable.muf_117, R.drawable.muf_18,
            };
    public MuffinAdapter(Context c){ mContext = c; }

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
