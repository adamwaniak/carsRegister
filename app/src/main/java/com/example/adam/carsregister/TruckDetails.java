package com.example.adam.carsregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TruckDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck_details);
        Intent intent = getIntent();
        Bundle truckData = intent.getBundleExtra("truckData");

        String name = truckData.getString("name");
        String capacity = truckData.getString("capacity");
        String brand = truckData.getString("brand");
        String rating = truckData.getString("rating");
        TextView nameTextView = (TextView) findViewById(R.id.truckNameTextView);
        nameTextView.setText(name);

        TextView capacityTextView = (TextView) findViewById(R.id.capacityTextView);
        capacityTextView.setText(capacity);

        TextView brandTextView = (TextView) findViewById(R.id.brandTextView);
        brandTextView.setText(brand);

        TextView ratingTextView = (TextView) findViewById(R.id.ratingTextView);
        ratingTextView.setText(rating);
    }
}
