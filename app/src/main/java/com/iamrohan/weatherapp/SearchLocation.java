package com.iamrohan.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class
SearchLocation extends AppCompatActivity {

    EditText searchCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_loaction);

        searchCity = findViewById(R.id.searchCity);

        searchCity.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                String newCity = searchCity.getText().toString();
                Intent i = new Intent(SearchLocation.this,MainActivity.class);
                i.putExtra("city",newCity);
                startActivity(i);

                return false;
            }
        });

    }
}