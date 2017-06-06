package com.example.adam.carsregister.InputFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;

import com.example.adam.carsregister.Car;
import com.example.adam.carsregister.MainFragments.ShowCarsFragment;
import com.example.adam.carsregister.R;



public class CarInputFragment extends Fragment {

    Button saveButton;
    EditText name;
    SeekBar numberOfSeats;
    CheckBox isRacingCar;
    public CarInputFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_car_input, container, false);
        name = (EditText) view.findViewById(R.id.CarNameEditText);
        numberOfSeats = (SeekBar) view.findViewById(R.id.numberOfSeats);
        isRacingCar = (CheckBox) view.findViewById(R.id.isRacingCarCheckBox);
        saveButton = (Button) view.findViewById(R.id.saveCarButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String carName = name.getText().toString();
                int carNumberOfSeats = numberOfSeats.getProgress();
                boolean carIsRacingCar = isRacingCar.isChecked();
                Car car = new Car(carName,carNumberOfSeats,carIsRacingCar);
                ShowCarsFragment.addCar(car);
            }
        });

        return view;
    }
}


