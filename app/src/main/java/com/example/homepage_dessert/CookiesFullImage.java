package com.example.homepage_dessert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class CookiesFullImage extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.cis_full_images);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        CookiesImage imageAdapter = new CookiesImage(this);

        ImageView imageView = (ImageView) findViewById(R.id.cis_full_image_view);
        imageView.setImageResource(imageAdapter.thumbImages[position]);

        Toast.makeText(this, "Full view image" + position, Toast.LENGTH_SHORT).show();

    }
}
