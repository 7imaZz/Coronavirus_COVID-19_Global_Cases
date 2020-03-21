package com.example.coronavirusglobalcases;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoronaApi {

    @GET("countries")
    Call<List<Country>> countryList();
}
