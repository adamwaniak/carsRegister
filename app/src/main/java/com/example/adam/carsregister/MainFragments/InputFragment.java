package com.example.adam.carsregister.MainFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.adam.carsregister.InputFragments.CarInputFragment;
import com.example.adam.carsregister.InputFragments.TruckInputFragment;
import com.example.adam.carsregister.R;


public class InputFragment extends Fragment {

    Fragment carFragment;
    Fragment truckFragment;
    Button carInputButton;
    Button truckInputButton;

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        carFragment = new CarInputFragment();
        truckFragment = new TruckInputFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_input, container, false);
        carInputButton = (Button) view.findViewById(R.id.carInputButton);
        truckInputButton = (Button) view.findViewById(R.id.truckInputButton);

        carInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInputFragment(carFragment);
            }
        });
        truckInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInputFragment(truckFragment);
            }
        });
        return view;
    }



    private void setInputFragment(Fragment fragment){
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.inputFrameLayout, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

}

