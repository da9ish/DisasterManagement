package com.codebreaker.disastermanagement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;

public class MapsFragment extends Fragment{

    private GoogleMap mMap;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    double lat[], lon[];
    String names[];
    MapView mapView;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_maps, container, false);

        lat = new double[9];
        lon = new double[9];
        names = new String[9];

        recyclerView = (RecyclerView) v.findViewById(R.id.rv);
        mapView = (MapView) v.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

        mapView.onResume();

        MapsInitializer.initialize(getActivity().getApplicationContext());

        preferences = getContext().getSharedPreferences("com.code-breakers.dm", MODE_PRIVATE);
        editor = preferences.edit();
        lat[0] = Double.parseDouble(preferences.getString("lat", "0.0"));
        lon[0] = Double.parseDouble(preferences.getString("lon", "0.0"));

        new FetchDetail().execute();

        return v;
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;

        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    class FetchDetail extends AsyncTask<Void,Void,Void>{

        ArrayList<HashMap<String, String>> data = new ArrayList<>();

        @Override
        protected Void doInBackground(Void... params) {

            HttpURLConnection urlConnection = null;

            try {
                URL url = new URL("http://192.168.92.28:80/dm/camps.php");
                urlConnection = (HttpURLConnection) url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                String line;
                StringBuffer json = new StringBuffer();
                while ((line = reader.readLine()) != null) {
                    json.append(line);
                }
                System.out.println(json);

                JSONArray array = new JSONArray(json.toString());
                for(int i=0;i<array.length();i++){
                    JSONObject main = array.getJSONObject(i);
                    HashMap<String, String> map = new HashMap<>();

                    String id = String.valueOf(main.getInt("_id"));
                    String name = main.getString("name");
                    names[i+1] = name;
                    String occupied = main.getString("occupied");
                    String capacity = main.getString("capacity");
                    double latitude = main.getDouble("latitude");
                    System.out.println(latitude);
                    double longitude = main.getDouble("Longitude");
                    String services = main.getString("services");
                    String head_name = main.getString("head_name");
                    String head_phone_no = main.getString("head_phone_no");

                    editor.putString("phone_no", head_phone_no).commit();

                    lat[i+1] = latitude;
                    lon[i+1] = longitude;
                    map.put("id", id);
                    map.put("name", name);
                    map.put("people_status", occupied+"/"+capacity+"\npeoples");
                    map.put("lat", String.valueOf(latitude));
                    map.put("lon", String.valueOf(longitude));
                    map.put("services", services);
                    map.put("head_name", head_name);
                    map.put("head_phone_no", head_phone_no);
                    double lat = Double.parseDouble(preferences.getString("lat", "0.0"));
                    double lon = Double.parseDouble(preferences.getString("lon", "0.0"));
                    double dist = distance(lat, lon, latitude, longitude);
                    String dist_new = new DecimalFormat("#.##").format(dist);
                    map.put("distance", dist_new+" Km");
                    data.add(map);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    mMap = googleMap;

                    // Add a marker in Sydney and move the camera

                    for (int i=0;i<lat.length;i++) {
                            System.out.println(lat + ", " + lon);
                        LatLng currentLocation = new LatLng(lat[i], lon[i]);
                        if (i==0) {
                            mMap.addMarker(new MarkerOptions().position(currentLocation).title("Current Location"));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation));
                            mMap.setMaxZoomPreference(14.0f);
                            mMap.animateCamera(CameraUpdateFactory.newLatLng(currentLocation));
                        }else {
                            mMap.addMarker(new MarkerOptions().position(currentLocation).title(names[i] + "Camp"));
                        }
                    }
                }
            });
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(new CampsAdapter(getContext(), data));


        }
    }

    class CampsAdapter extends RecyclerView.Adapter<CampsViewHolder>{

        ArrayList<HashMap<String, String>> data;
        Context cxt;

        public CampsAdapter(Context cxt, ArrayList<HashMap<String,String>> data) {
            this.cxt = cxt;
            this.data = data;

            for(int i=0;i<data.size();i++){
                HashMap<String, String> map = data.get(i);
                HashMap<String, String> map1 = data.get(i+1);

                if (map1>map){

                }
            }
        }

        @Override
        public CampsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(cxt).inflate(R.layout.item_camp, parent, false);

            return new CampsViewHolder(v);
        }

        @Override
        public void onBindViewHolder(CampsViewHolder holder, int position) {

            final HashMap<String, String> map = data.get(position);

            if(map.get("distance")>)

            holder.name.setText(map.get("name"));
            holder.service.setText(map.get("head_name"));
            holder.people.setText(map.get("distance"));
            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent detail = new Intent(getActivity(), DetailActivity.class);
                    detail.putExtra("id", map.get("id"));
                    cxt.startActivity(detail);
                }
            });

        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    class CampsViewHolder extends RecyclerView.ViewHolder{

        TextView name, service, people;
        LinearLayout card;

        public CampsViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            service = (TextView) itemView.findViewById(R.id.services);
            people = (TextView) itemView.findViewById(R.id.capacity);
            card = (LinearLayout) itemView.findViewById(R.id.camp_card);

        }
    }


}

