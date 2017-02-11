package com.codebreaker.disastermanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

/**
 * Created by bilal on 28-01-2017.
 */

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient mGoogleClient;
    private Location mlastlocation;
    static double lat = 0.0, lon = 0.0;
    LocationManager manager;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("com.code-breakers.dm", MODE_PRIVATE);
        String user;
        user = preferences.getString("user_name", null);
        System.out.println(user);
        boolean login ;
        if (user == null){
            login = true;
        }else{
            login = false;
        }

        if (login){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        preferences = getSharedPreferences("com.code-breakers.dm",MODE_PRIVATE);
        editor = preferences.edit();

        LinearLayout alert = (LinearLayout) findViewById(R.id.alert);
        LinearLayout map = (LinearLayout) findViewById(R.id.map);

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTab(1);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTab(2);
            }
        });


        manager = (LocationManager) getSystemService(this.LOCATION_SERVICE);

        manager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        mGoogleClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .enableAutoManage(this, this)
                .build();

        changeTab(2);

    }

    public void changeTab(int postiton){
        switch (postiton){
            case 1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main, new AlertFragment())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main, new MapsFragment())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
                break;

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length > 0){
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        System.out.println("on request result");
                        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                            mlastlocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleClient);
                        }

                        if (mlastlocation != null){
                            lat = mlastlocation.getLatitude();
                            lon = mlastlocation.getLongitude();
                            editor.putString("lat", String.valueOf(lat)).commit();
                            editor.putString("lon", String.valueOf(lon)).commit();
                            System.out.println("Conn: "+lat+ ", " +lon);
                        }

//                        startActivity(new Intent(this, MapsFragment.class));
//                        finish();
                    }
                }

        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            requestLocationPermission();

        }else {
            mlastlocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleClient);

            if (mlastlocation != null) {
                lat = mlastlocation.getLatitude();
                lon = mlastlocation.getLongitude();
                editor.putString("lat", String.valueOf(lat)).commit();
                editor.putString("lon", String.valueOf(lon)).commit();
                System.out.println("Conn: " + lat + ", " + lon);
            }
//            startActivity(new Intent(this, MapsFragment.class));
//            finish();
        }

    }

    public void requestLocationPermission(){

        System.out.println("requesting");

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        } else {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onStart() {
        mGoogleClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        mGoogleClient.disconnect();
        super.onStop();
    }
}
