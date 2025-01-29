package com.example.homepage_dessert;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class OrderDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "orders.db";
    private static final int DATABASE_VERSION = 3;  // 🔼 Increment the version!


    public OrderDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE orders (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "phone_number TEXT NOT NULL, " +
                "category TEXT NOT NULL, " +
                "item TEXT NOT NULL, " +
                "quantity TEXT NOT NULL, " +
                "pickup_time TEXT NOT NULL)");

        Log.d("DATABASE", "✅ Database Created with Correct Schema");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("DATABASE", "⚠️ Upgrading database from version " + oldVersion + " to " + newVersion);

        // 🛑 Drop old table if it exists
        db.execSQL("DROP TABLE IF EXISTS orders");

        // 🔄 Recreate the table
        onCreate(db);

        Log.d("DATABASE", "✅ Database upgraded successfully!");
    }

}
