package com.example.homepage_dessert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class CakesFullImage extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.cakes_full_images);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        CakesAdapter imageAdapter = new CakesAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.cakes_full_image_view);
        imageView.setImageResource(imageAdapter.thumbImages[position]);

        Toast.makeText(this, "Full view image" + position, Toast.LENGTH_SHORT).show();

    }
}
