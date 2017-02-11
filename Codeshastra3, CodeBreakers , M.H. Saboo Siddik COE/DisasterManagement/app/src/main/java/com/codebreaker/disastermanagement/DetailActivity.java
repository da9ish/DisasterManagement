package com.codebreaker.disastermanagement;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bilal on 29-01-2017.
 */

public class DetailActivity extends AppCompatActivity {

    String id;
    RequestQueue requestQueue;
    TextView camp, head, phone, cap, occ, serv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        requestQueue = Volley.newRequestQueue(this);
        Bundle bundle = getIntent().getExtras();

        id = bundle.getString("id");

        camp = (TextView) findViewById(R.id.camp);
        head = (TextView) findViewById(R.id.head);
        phone = (TextView) findViewById(R.id.head_phone);
        cap = (TextView) findViewById(R.id.capacity);
        occ = (TextView) findViewById(R.id.occupied);
        serv = (TextView) findViewById(R.id.services);

        getData();

    }

    public void getData() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.92.28:80/dm/camp_data.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                parseJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DetailActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String, String> map = new HashMap<>();
                map.put("id", id);
                return map;
            }
        };

        requestQueue.add(stringRequest);
    }

    public void parseJSON(String json) {

        try {
            JSONArray array = new JSONArray(json);

            JSONObject main = array.getJSONObject(0);
            HashMap<String, String> map = new HashMap<>();

            String name = main.getString("name");
            String occupied = main.getString("occupied");
            String capacity = main.getString("capacity");
            double latitude = main.getDouble("latitude");
            System.out.println(latitude);
            double longitude = main.getDouble("Longitude");
            String services = main.getString("services");
            String head_name = main.getString("head_name");
            String head_phone_no = main.getString("head_phone_no");

            camp.setText(name+" Camp");
            head.setText("Head: "+head_name);
            phone.setText("Phone No: "+head_phone_no);
            cap.setText("Capacity: "+capacity);
            occ.setText("Occupied: "+occupied);
            serv.setText("Services: "+services);



        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }


}
