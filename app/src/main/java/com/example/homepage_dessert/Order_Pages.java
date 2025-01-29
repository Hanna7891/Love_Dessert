package com.example.homepage_dessert;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log; // Debugging
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Order_Pages extends AppCompatActivity {
    private Spinner spinnerCategory, spinnerItems, spinnerPickupTime;
    private EditText editTextQuantity, editTextPhoneNumber;
    private Button buttonOrder, buttonViewOrders, backButton;
    private OrderDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pages);

        dbHelper = new OrderDatabaseHelper(this);

        // Initialize UI components
        spinnerCategory = findViewById(R.id.spinnerCategory);
        spinnerItems = findViewById(R.id.spinnerItems);
        spinnerPickupTime = findViewById(R.id.spinnerPickupTime);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        buttonOrder = findViewById(R.id.buttonOrder);
        buttonViewOrders = findViewById(R.id.buttonViewOrders);
        backButton = findViewById(R.id.button_back);

        // Set up category spinner
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(
                this, R.array.category_array, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryAdapter);

        // Set up item spinner based on category selection
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                loadItemsForCategory(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Set up pickup time spinner
        ArrayAdapter<CharSequence> pickupTimeAdapter = ArrayAdapter.createFromResource(
                this, R.array.pickup_times, android.R.layout.simple_spinner_item);
        pickupTimeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPickupTime.setAdapter(pickupTimeAdapter);

        // Order button click listener
        buttonOrder.setOnClickListener(v -> placeOrder());

        // View orders button click listener
        buttonViewOrders.setOnClickListener(v -> {
            String phoneNumber = editTextPhoneNumber.getText().toString().trim();
            if (phoneNumber.isEmpty()) {
                Toast.makeText(this, "❌ Please enter your phone number!", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(Order_Pages.this, ViewOrdersActivity.class);
            intent.putExtra("phone_number", phoneNumber);
            startActivity(intent);
        });


        backButton.setOnClickListener(v -> finish());
    }

    private void loadItemsForCategory(int categoryPosition) {
        String[] items = getResources().getStringArray(R.array.items_array);
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, items);
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerItems.setAdapter(itemsAdapter);
    }

    private void placeOrder() {
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();
        String category = spinnerCategory.getSelectedItem().toString(); // ✅ Include category
        String item = spinnerItems.getSelectedItem().toString();
        String quantity = editTextQuantity.getText().toString().trim();
        String pickupTime = spinnerPickupTime.getSelectedItem().toString();

        Log.d("DEBUG", "📞 Phone Number: " + phoneNumber);
        Log.d("DEBUG", "📂 Category: " + category);
        Log.d("DEBUG", "🍰 Item: " + item);
        Log.d("DEBUG", "🛒 Quantity: " + quantity);
        Log.d("DEBUG", "⏰ Pickup Time: " + pickupTime);

        if (phoneNumber.isEmpty() || category.isEmpty() || item.isEmpty() || quantity.isEmpty() || pickupTime.isEmpty()) {
            Toast.makeText(this, "❌ Please fill in all fields!", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (db == null) {
            Toast.makeText(this, "❌ Database error! Unable to open.", Toast.LENGTH_SHORT).show();
            Log.e("DATABASE_ERROR", "❌ ERROR: Unable to open database");
            return;
        }

        try {
            ContentValues values = new ContentValues();
            values.put("phone_number", phoneNumber);
            values.put("category", category); // ✅ Include category
            values.put("item", item);
            values.put("quantity", quantity);
            values.put("pickup_time", pickupTime);

            long newRowId = db.insert("orders", null, values);

            if (newRowId == -1) {
                Toast.makeText(this, "❌ Failed to place order.", Toast.LENGTH_SHORT).show();
                Log.e("DATABASE_ERROR", "❌ ERROR: Failed to insert into database");
            } else {
                Toast.makeText(this, "✅ Order placed successfully!", Toast.LENGTH_SHORT).show();

                getSharedPreferences("CustomerPrefs", MODE_PRIVATE)
                        .edit()
                        .putString("phone_number", phoneNumber)
                        .apply();

                resetForm();
            }
        } catch (Exception e) {
            Log.e("DATABASE_ERROR", "❌ Exception during insertion: " + e.getMessage());
            Toast.makeText(this, "❌ Unexpected error occurred!", Toast.LENGTH_SHORT).show();
        } finally {
            db.close();
        }
    }



    private void resetForm() {
        editTextQuantity.setText("");
        editTextPhoneNumber.setText("");
        spinnerCategory.setSelection(0);
        spinnerItems.setSelection(0);
        spinnerPickupTime.setSelection(0);
    }
}
