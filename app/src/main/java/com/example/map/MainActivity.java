package com.example.map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.mapview.MapScheme;
import com.here.sdk.mapview.MapView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding = ActivityMainBinding binding.
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragmentContainerView, FragmentMap.class, null)
                    .commit();
        }
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.homepage);
    }

    FragmentMap fragmentMap = new FragmentMap();
    FragmentHomepage fragmentHomepage = new FragmentHomepage();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.homepage) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentHomepage).commit();
            return true;
        } else if (item.getItemId() == R.id.map) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentMap).commit();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (bottomNavigationView.getSelectedItemId() == R.id.map) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentHomepage).commit();
            bottomNavigationView.setSelectedItemId(R.id.homepage);
        } else if(bottomNavigationView.getSelectedItemId() == R.id.homepage){
            super.onBackPressed();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}