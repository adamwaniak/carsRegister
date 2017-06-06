package com.example.adam.carsregister;

import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.adam.carsregister.MainFragments.InputFragment;
import com.example.adam.carsregister.MainFragments.ShowCarsFragment;
import com.example.adam.carsregister.MainFragments.ShowTrucksFragment;
import com.example.adam.carsregister.MainFragments.WelcomeFragment;

public class MainActivity extends AppCompatActivity {


    TabLayout tabLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = (TabLayout) findViewById(R.id.simpleTabLayout);

        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("Start");

        tabLayout.addTab(firstTab);


        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("Enter data");
        tabLayout.addTab(secondTab);

        TabLayout.Tab thirdTab = tabLayout.newTab();
        thirdTab.setText("cars");
        thirdTab.setIcon(R.drawable.car_image);
        tabLayout.addTab(thirdTab);

        TabLayout.Tab fourthTab = tabLayout.newTab();
        fourthTab.setText("trucks");
        fourthTab.setIcon(R.drawable.truck_image);
        tabLayout.addTab(fourthTab);

        Fragment fragment = new WelcomeFragment();
        setSimpleFrameLayout(fragment);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new WelcomeFragment();
                        break;
                    case 1:
                        fragment = new InputFragment();
                        break;
                    case 2:
                        fragment = new ShowCarsFragment();
                        break;
                    case 3:
                        fragment = new ShowTrucksFragment();
                        break;
                }
                setSimpleFrameLayout(fragment);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    private void setSimpleFrameLayout(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.simpleFrameLayout, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
