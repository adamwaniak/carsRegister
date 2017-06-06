package com.example.adam.carsregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CarDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        Intent intent = getIntent();
        Bundle carData = intent.getBundleExtra("carData");

        String name = carData.getString("name");
        int numOfSeats = carData.getInt("seats",0);
        boolean isRacingCar = carData.getBoolean("racingCar",false);
        String carType = isRacingCar ? "racing car" : "normal car";
        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        nameTextView.setText(name);

        TextView seats = (TextView) findViewById(R.id.numberOfSeatsTextView);
        seats.setText(String.valueOf(numOfSeats));

        TextView racingCar = (TextView) findViewById(R.id.racingCarTextBox);
        racingCar.setText(carType);
    }
}
