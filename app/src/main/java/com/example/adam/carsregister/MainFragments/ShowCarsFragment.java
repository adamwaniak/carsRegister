package com.example.adam.carsregister.MainFragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adam.carsregister.Car;
import com.example.adam.carsregister.CarDetails;
import com.example.adam.carsregister.MainActivity;
import com.example.adam.carsregister.R;

import java.util.ArrayList;


public class ShowCarsFragment extends Fragment {
    ListView carsList;
    private static ArrayList<Car> cars = new ArrayList<>();
    private static ArrayList<String> names = new ArrayList<>();

    public ShowCarsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_cars, container, false);
        carsList = (ListView) view.findViewById(R.id.carsListView);
        ArrayAdapter adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1);

        names = getNames();

        adapter.addAll(names);
        carsList.setAdapter(adapter);


        carsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), CarDetails.class);
                Bundle carData = new Bundle();
                Car car = cars.get(position);
                carData.putString("name",car.getName());
                carData.putInt("seats",car.getNumberOfSeats());
                carData.putBoolean("racingCar",car.isRacingCar());
                intent.putExtra("carData",carData);
                startActivity(intent);
            }
        });
        return view;
    }

    public static void addCar(Car car){
        cars.add(car);
    }
    private static ArrayList<String> getNames(){
        ArrayList<String> names = new ArrayList<>();
        for(Car car:cars){
            names.add(car.getName());
        }
        return names;
    }


}
