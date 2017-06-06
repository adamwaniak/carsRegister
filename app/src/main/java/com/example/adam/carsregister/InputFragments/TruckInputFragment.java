package com.example.adam.carsregister.InputFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.example.adam.carsregister.Car;
import com.example.adam.carsregister.MainFragments.ShowCarsFragment;
import com.example.adam.carsregister.MainFragments.ShowTrucksFragment;
import com.example.adam.carsregister.R;
import com.example.adam.carsregister.Truck;

import java.util.ArrayList;


public class TruckInputFragment extends Fragment {
    Button saveButton;
    EditText name;
    EditText capacity;
    Spinner brand;
    RatingBar rating;

    ArrayList<String> brands = new ArrayList<String>();

    public TruckInputFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        brands.add("mercedes");
        brands.add("WV");
        brands.add("Fiat");

        View view =  inflater.inflate(R.layout.fragment_truck_input, container, false);
        name = (EditText) view.findViewById(R.id.truckNameEditText);
        capacity = (EditText) view.findViewById(R.id.capacityEditText);
        brand = (Spinner) view.findViewById(R.id.brandSpinner);
        ArrayAdapter adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_dropdown_item,brands);
        brand.setAdapter(adapter);

        rating = (RatingBar) view.findViewById(R.id.ratingBar);
        saveButton = (Button) view.findViewById(R.id.saveTruckButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String truckName = name.getText().toString();
                String truckCapacity = capacity.getText().toString();
                String truckBrand = brand.getSelectedItem().toString();
                String truckRating = Float.toString(rating.getRating());
                Truck truck = new Truck(truckName,truckCapacity,truckBrand,truckRating);
                ShowTrucksFragment.addTruck(truck);
            }
        });

        return view;
    }

}
