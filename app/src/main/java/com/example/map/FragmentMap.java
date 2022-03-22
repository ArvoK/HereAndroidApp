package com.example.map;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.mapview.MapImage;
import com.here.sdk.mapview.MapImageFactory;
import com.here.sdk.mapview.MapMarker;
import com.here.sdk.mapview.MapScheme;
import com.here.sdk.mapview.MapView;

import java.util.Date;

public class FragmentMap extends Fragment {

    public FragmentMap() {
        super(R.layout.fragment_map);

    }

    private MapView mapView;
    private PlatformPositioningProvider platformPositioningProvider;
    private GeoCoordinates geoCoordinates;

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        geoCoordinates = new GeoCoordinates(52.54175, 13.351628, 1000);
        mapView = view.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        loadMapScene();

        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centerMap();
            }
        });
    }

    private void loadMapScene() {
        mapView.getMapScene().loadScene(MapScheme.NORMAL_DAY, mapError -> {
            if (mapError == null) {
                mapView.getCamera().lookAt(geoCoordinates);

            } else {
                //log the error
            }
        });

    }

    private void centerMap() {
        geoCoordinates = new GeoCoordinates(Math.random()*180-90, Math.random()*360-180, 10000000);

        mapView.getCamera().lookAt(geoCoordinates);
    }


}
