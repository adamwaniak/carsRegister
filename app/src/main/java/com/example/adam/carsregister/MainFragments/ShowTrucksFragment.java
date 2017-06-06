package com.example.adam.carsregister.MainFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adam.carsregister.R;
import com.example.adam.carsregister.Truck;
import com.example.adam.carsregister.TruckDetails;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowTrucksFragment extends Fragment {

    private static ArrayList<Truck> trucks = new ArrayList<>();
    private ArrayList<String> names;
    ListView trucksList;
    public ShowTrucksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_trucks, container, false);
        trucksList = (ListView) view.findViewById(R.id.trucksListView);
        ArrayAdapter adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1);

        names = getNames();

        adapter.addAll(names);
        trucksList.setAdapter(adapter);


        trucksList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), TruckDetails.class);
                Bundle truckData = new Bundle();
                Truck truck = trucks.get(position);
                truckData.putString("name",truck.getName());
                truckData.putString("capacity",truck.getCapacity());
                truckData.putString("brand",truck.getBrand());
                truckData.putString("rating",truck.getRating());
                intent.putExtra("truckData",truckData);
                startActivity(intent);
            }
        });
        return view;
    }

    public static void addTruck(Truck truck) {
        trucks.add(truck);
    }
    private ArrayList<String> getNames(){
        ArrayList<String> names = new ArrayList<>();
        for(Truck truck: trucks){
            names.add(truck.getName());
        }
        return names;
    }
}
