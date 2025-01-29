package com.example.homepage_dessert;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splash_screen extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen); // Ensure you set the content view

        // Add a delay before starting HomePage
        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, homepage.class)); // Change to HomePage
            finish(); // Ensures SplashScreen is removed from the back stack
        }, 2000); // 2-second delay
    }
}