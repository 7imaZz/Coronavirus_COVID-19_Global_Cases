package com.example.coronavirusglobalcases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView countriesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countriesRecyclerView = findViewById(R.id.rv_countries);

        countriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        countriesRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        List<Country> countries = new ArrayList<>();
        countries.add(new Country("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Flag_of_Eswatini.svg/100px-Flag_of_Eswatini.svg.png",
                "Estonia","100", "27","11", "30", "25", "2"));
        countries.add(new Country("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Flag_of_Eswatini.svg/100px-Flag_of_Eswatini.svg.png",
                "Estonia","100", "27","11", "30", "25", "2"));
        countries.add(new Country("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Flag_of_Eswatini.svg/100px-Flag_of_Eswatini.svg.png",
                "Estonia","100", "27","11", "30", "25", "2"));
        countries.add(new Country("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Flag_of_Eswatini.svg/100px-Flag_of_Eswatini.svg.png",
                "Estonia","100", "27","11", "30", "25", "2"));
        countries.add(new Country("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Flag_of_Eswatini.svg/100px-Flag_of_Eswatini.svg.png",
                "Estonia","100", "27","11", "30", "25", "2"));

        CountriesAdapter countriesAdapter = new CountriesAdapter(MainActivity.this, countries);
        countriesRecyclerView.setAdapter(countriesAdapter);


    }
}
