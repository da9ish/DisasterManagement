package com.codebreaker.disastermanagement;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.LocationServices;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by bilal on 28-01-2017.
 */

public class AlertFragment extends Fragment {

    EditText text;
    FloatingActionButton alert, call;
    String note = null;
    SharedPreferences preferences;
    Intent call_it;
    RequestQueue requestQueue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_alert, container, false);

        text = (EditText) v.findViewById(R.id.note);
        alert = (FloatingActionButton) v.findViewById(R.id.alert);
        call = (FloatingActionButton) v.findViewById(R.id.call);

        requestQueue = new Volley().newRequestQueue(getContext());
        preferences = getContext().getSharedPreferences("com.code-breakers.dm", MODE_PRIVATE);

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData(v);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_it = new Intent(Intent.ACTION_CALL);
                call_it.setData(Uri.parse("tel:" + preferences.getString("phone_no", "022 123 456")));
                if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    requestCallPermission();
                    return;
                }
                getContext().startActivity(call_it);
            }
        });


        return v;
    }

    public void requestCallPermission(){

        System.out.println("requesting");

        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CALL_PHONE)) {

            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 1);

        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length > 0){
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                            getContext().startActivity(call_it);


//                        getContext()startActivity(new Intent(this, MapsFragment.class));
//                        finish();
                    }
                }

        }
    }

    public void sendData(final View v){

        note = text.getText().toString().trim();
        System.out.println(note + preferences.getString("lat", "0.0"));

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.92.28:80/dm/send_alert.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(v.getContext(), response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(v.getContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String, String> map = new HashMap<>();
                map.put("name", preferences.getString("user_name", null));
                map.put("note", note);
                map.put("lat", preferences.getString("lat", "0.0"));
                map.put("lon", preferences.getString("lon", "0.0"));
                return map;
            }
        };

        requestQueue.add(stringRequest);

    }
}
