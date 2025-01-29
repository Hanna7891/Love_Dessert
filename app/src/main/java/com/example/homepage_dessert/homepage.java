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

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Button menuButton = findViewById(R.id.button_menu);
        Button orderButton = findViewById(R.id.button_order);
        Button aboutUsButton = findViewById(R.id.button_about_us);
        Button contactUsButton = findViewById(R.id.button_contact_us);
        Button teamButtom = findViewById(R.id.button_our_team);
        Button promButtom = findViewById(R.id.button_prom);


        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("HomePage", "Menu button clicked"); // Log statement
                Intent intent = new Intent(homepage.this, Menu_Pages.class);
                startActivity(intent);
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, Order_Pages.class);
                startActivity(intent);
            }
        });

        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, About_Pages.class);
                startActivity(intent);
            }
        });

        contactUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, Contact_Pages.class);
                startActivity(intent);
            }
        });

        teamButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, Team_Pages.class);
                startActivity(intent);
            }
        });


        promButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, QR_Reader.class);
                startActivity(intent);
            }
        });
    }
}