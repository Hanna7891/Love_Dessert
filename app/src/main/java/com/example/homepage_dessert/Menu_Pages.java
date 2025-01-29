package com.example.homepage_dessert;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Menu_Pages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_pages);

        Button macaronButton = findViewById(R.id.button_macaron);
        Button cakeButton = findViewById(R.id.button_cake);
        Button muffinButton = findViewById(R.id.button_muffin);
        Button cookiesButton = findViewById(R.id.button_cookies);
        Button backButton = findViewById(R.id.button_back);


        macaronButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("HomePage", "Menu button clicked"); // Log statement
                Intent intent = new Intent(Menu_Pages.this, Macaron_Pages.class);
                startActivity(intent);
            }
        });

        cakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_Pages.this, Cake_Pages.class);
                startActivity(intent);
            }
        });

        muffinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_Pages.this, Muffin_Pages.class);
                startActivity(intent);
            }
        });

        cookiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_Pages.this, Cookies_Pages.class);
                startActivity(intent);
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // This will close the current activity and return to the previous one
            }
        });
    }
}