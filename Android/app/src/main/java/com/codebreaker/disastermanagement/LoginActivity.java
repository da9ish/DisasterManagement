package com.codebreaker.disastermanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bilal on 29-01-2017.
 */

public class LoginActivity extends AppCompatActivity {

    EditText name, phone, pass;
    Button register;
    RequestQueue requestQueue;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone_no);
        pass = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.reg);

        preferences = getSharedPreferences("com.code-breakers.dm", MODE_PRIVATE);
        editor = preferences.edit();


        requestQueue = Volley.newRequestQueue(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    public void registerUser(){
        final String name_txt = name.getText().toString().trim();
        final String phone_txt = phone.getText().toString().trim();
        final String pass_txt = pass.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.92.28:80/dm/register_user.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                if (response.equals("Registered")){
                    editor.putString("user_name", name_txt).commit();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }else{

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String, String> map = new HashMap<>();
                map.put("user_name", name_txt);
                map.put("phone", phone_txt);
                map.put("pass", pass_txt);
                return map;
            }
        };

        requestQueue.add(stringRequest);

    }
}
