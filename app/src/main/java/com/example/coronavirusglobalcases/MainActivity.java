package com.example.coronavirusglobalcases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView countriesRecyclerView;
    private ProgressBar progressBar;
    private SwipeRefreshLayout refreshLayout;
    private TextView noInternetTextView;
    private List<Country> countries = new ArrayList<>();
    private CountriesAdapter countriesAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countriesRecyclerView = findViewById(R.id.rv_countries);
        progressBar = findViewById(R.id.pb_loading);
        refreshLayout = findViewById(R.id.refresh);
        noInternetTextView = findViewById(R.id.tv_no_internet);


        countriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        countriesRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            noInternetTextView.setVisibility(View.GONE);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://coronavirus-19-api.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            CoronaApi coronaApi = retrofit.create(CoronaApi.class);
            Call<List<Country>> call = coronaApi.countryList();


            call.enqueue(new Callback<List<Country>>() {
                @Override
                public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                    countries = response.body();


                    countriesAdapter = new CountriesAdapter(MainActivity.this, countries);

                    countriesRecyclerView.setAdapter(countriesAdapter);
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<List<Country>> call, Throwable t) {

                }
            });

        }
        else{
            progressBar.setVisibility(View.GONE);
        }




        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                countriesAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
