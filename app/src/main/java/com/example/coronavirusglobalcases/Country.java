package com.example.coronavirusglobalcases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("country")
    @Expose
    private String name;
    @SerializedName("cases")
    @Expose
    private String cases;
    @SerializedName("deaths")
    @Expose
    private String deaths;
    @SerializedName("recovered")
    @Expose
    private String recovered;
    @SerializedName("todayCases")
    @Expose
    private String todayCases;
    @SerializedName("todayDeaths")
    @Expose
    private String todayDeaths;
    @SerializedName("active")
    @Expose
    private String active;


    public Country(String rank, String name, String cases, String deaths, String recovered, String todayCases, String todayDeaths, String active) {
        this.rank = rank;
        this.name = name;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
        this.todayCases = todayCases;
        this.todayDeaths = todayDeaths;
        this.active = active;
    }


    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
