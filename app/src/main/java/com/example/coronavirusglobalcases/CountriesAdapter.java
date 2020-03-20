package com.example.coronavirusglobalcases;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> {



    public class CountriesViewHolder extends RecyclerView.ViewHolder {

        private TextView rankTextView,countryTextView, casesTextView, deathsTextView, recoveryTextView, toCasesTextView
                ,toDeathsTextView, activeTextView;

        public CountriesViewHolder(@NonNull View itemView) {
            super(itemView);

            rankTextView = itemView.findViewById(R.id.tv_rank);
            countryTextView = itemView.findViewById(R.id.tv_country_name);
            casesTextView = itemView.findViewById(R.id.tv_cases);
            deathsTextView = itemView.findViewById(R.id.tv_deaths);
            recoveryTextView = itemView.findViewById(R.id.tv_recovered);
            toCasesTextView = itemView.findViewById(R.id.tv_to_cases);
            toDeathsTextView = itemView.findViewById(R.id.tv_to_deaths);
            activeTextView = itemView.findViewById(R.id.tv_active);
        }
    }

    private Context context;
    private List<Country> countries;

    public CountriesAdapter(Context context, List<Country> countries) {
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountriesAdapter.CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new CountriesViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CountriesAdapter.CountriesViewHolder holder, int position) {

        Country currentCountry = countries.get(position);

        holder.rankTextView.setText(position+1+"");
        holder.countryTextView.setText(currentCountry.getName());
        holder.casesTextView.setText("Cases: "+currentCountry.getCases());
        holder.deathsTextView.setText("Deaths: "+currentCountry.getDeaths());
        holder.recoveryTextView.setText("Recovered: "+currentCountry.getRecovered());
        holder.toCasesTextView.setText("Today Cases: "+currentCountry.getTodayCases());
        holder.toDeathsTextView.setText("Today Deaths: "+currentCountry.getTodayDeaths());
        holder.activeTextView.setText("Active: "+currentCountry.getActive());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }


}
