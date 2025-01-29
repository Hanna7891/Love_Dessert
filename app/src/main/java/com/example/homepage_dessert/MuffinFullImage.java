package com.example.homepage_dessert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MuffinFullImage extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.muf_full_images);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        MuffinAdapter imageAdapter = new MuffinAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.muf_full_image_view);
        imageView.setImageResource(imageAdapter.thumbImages[position]);

        Toast.makeText(this, "Full view image" + position, Toast.LENGTH_SHORT).show();

    }
}
