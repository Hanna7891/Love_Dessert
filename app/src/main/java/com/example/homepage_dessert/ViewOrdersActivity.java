package com.example.homepage_dessert;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log; // Debugging
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ViewOrdersActivity extends AppCompatActivity {
    private ListView listViewOrders;
    private EditText editTextPhoneNumber;
    private Button buttonFetchOrders, buttonBack;
    private OrderDatabaseHelper dbHelper;
    private ArrayList<String> orderList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_orders);

        listViewOrders = findViewById(R.id.listViewOrders);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        buttonFetchOrders = findViewById(R.id.buttonFetchOrders);
        buttonBack = findViewById(R.id.buttonBack);
        dbHelper = new OrderDatabaseHelper(this);

        // 🔹 Get phone number from Intent
        String phoneNumber = getIntent().getStringExtra("phone_number");
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            editTextPhoneNumber.setText(phoneNumber);
            loadOrdersByPhoneNumber(phoneNumber); // 🔹 Load orders immediately
        }

        // 🔹 Fetch orders when button is clicked
        buttonFetchOrders.setOnClickListener(v -> {
            String enteredPhone = editTextPhoneNumber.getText().toString().trim();
            loadOrdersByPhoneNumber(enteredPhone);
        });

        // 🔹 Back button navigates to Homepage
        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(ViewOrdersActivity.this, homepage.class);
            startActivity(intent);
            finish();
        });
    }

    private void loadOrdersByPhoneNumber(String phoneNumber) {
        if (phoneNumber.isEmpty()) {
            Toast.makeText(this, "❌ Please enter a phone number!", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT phone_number, category, item, quantity, pickup_time FROM orders WHERE phone_number = ? ORDER BY id DESC",
                new String[]{phoneNumber});

        orderList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Log.d("DATABASE", "✅ Fetching order: " + cursor.getString(2)); // Debugging

                String order = "📞 Phone: " + cursor.getString(0) +
                        "\n📂 Category: " + cursor.getString(1) + // ✅ Include category
                        "\n🍰 Flavour: " + cursor.getString(2) +
                        "\n🛒 Quantity: " + cursor.getString(3) +
                        "\n⏰ Pickup Time: " + cursor.getString(4);
                orderList.add(order);
            } while (cursor.moveToNext());
        } else {
            orderList.add("❌ No orders found for this phone number.");
        }

        cursor.close();
        db.close();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orderList);
        listViewOrders.setAdapter(adapter);
    }
}

