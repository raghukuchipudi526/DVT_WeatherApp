package com.sample.weatherapp.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.sample.weatherapp.databinding.ForecastWeatherListItemBinding;
import com.sample.weatherapp.model.Forecast.List;

import java.util.Collections;

public class ForecastWeatherListAdapter extends RecyclerView.Adapter<ForecastWeatherListAdapter.CustomViewHolder> {

    private Activity activity;
    private java.util.List<List> forecastLists;
    public ForecastWeatherListAdapter(Activity activity, java.util.List<List> forecastLists) {
        this.activity = activity;
        this.forecastLists = forecastLists;
    }

    public ForecastWeatherListAdapter(Activity activity) {
        this.activity = activity;
        this.forecastLists = Collections.emptyList();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ForecastWeatherListItemBinding itemBinding = ForecastWeatherListItemBinding.inflate(layoutInflater, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(itemBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        List forecastList = getItem(position);
        holder.binding.dayTempTV.setText(String.valueOf(forecastList.getMain().getTemp()));
    }

    @Override
    public int getItemCount() {
        return forecastLists.size();
    }

    public List getItem(int position) {
        return forecastLists.get(position);
    }

    public void setForecastLists(java.util.List<List> forecastLists) {
        this.forecastLists = forecastLists;
        notifyDataSetChanged();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private ForecastWeatherListItemBinding binding;

        public CustomViewHolder(ForecastWeatherListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

