package com.sample.weatherapp.activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.weatherapp.R;
import com.sample.weatherapp.adapters.ForecastWeatherListAdapter;
import com.sample.weatherapp.databinding.WeatherActivityBinding;
import com.sample.weatherapp.model.Forecast.CurrentForecast;
import com.sample.weatherapp.model.Weather.CurrentWeather;
import com.sample.weatherapp.viewmodel.ForecastViewModel;
import com.sample.weatherapp.viewmodel.WeatherForecastViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class WeatherActivity extends AppCompatActivity implements Observer {

    private WeatherForecastViewModel weatherForecastViewModel;
    private ForecastViewModel forecastViewModel;
    private WeatherActivityBinding weatherActivityBinding;
    private List<com.sample.weatherapp.model.Forecast.List> forecastList;
    private static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    String latitude, longitude;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeDataBinding();
        ActivityCompat.requestPermissions( this,
                new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            OnGPS();
        } else {
            getLocation();
        }
        setupForecastList();
    }

    private void OnGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("Yes", new  DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (locationGPS != null) {
                double lat = locationGPS.getLatitude();
                double longi = locationGPS.getLongitude();
                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);
                setupViewModel(latitude, longitude);
                setupForecastViewModel(latitude, longitude);
            } else {
                Toast.makeText(this, "Unable to find location.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void initializeDataBinding() {
        weatherActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private void setupForecastList() {
        RecyclerView recyclerView = weatherActivityBinding.includedSimilarLayout.forecastList;
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager similarMoviesLayout = new LinearLayoutManager(this);
        similarMoviesLayout.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(similarMoviesLayout);
        recyclerView.smoothScrollToPosition(1);

        ForecastWeatherListAdapter forecastWeatherListAdapter = new ForecastWeatherListAdapter(this);
        recyclerView.setAdapter(forecastWeatherListAdapter);
    }

    private void setupViewModel(String latitude, String longitude) {
        weatherForecastViewModel = new WeatherForecastViewModel(getApplicationContext(), latitude, longitude);
        weatherForecastViewModel.addObserver(this);
        weatherForecastViewModel.fetchData();
    }

    private void setupForecastViewModel(String latitude, String longitude) {
        forecastList = new ArrayList<>();
        forecastViewModel = new ForecastViewModel(getApplicationContext(), latitude, longitude);
        forecastViewModel.addObserver(this);
        forecastViewModel.fetchData();
    }

    @Override
    public void update(Observable observable, Object object) {
        if (object instanceof CurrentWeather) {
            CurrentWeather currentWeather = (CurrentWeather) object;
            if (currentWeather != null) {
                if (currentWeather.getWeather().get(0).getMain().contains("Sunny") ||
                        currentWeather.getWeather().get(0).getMain().contains("Clear")) {
                    weatherActivityBinding.includedSimilarLayout.totalViewLL.setBackgroundColor(getResources().getColor(R.color.sunny));
                    weatherActivityBinding.includedSimilarLayout.topViewLL.setBackgroundColor(getResources().getColor(R.color.sunny));
                    weatherActivityBinding.includedSimilarLayout.tempTV.setBackgroundResource(R.drawable.forest_sunny);
                } else if (currentWeather.getWeather().get(0).getMain().contains("Rainy") ||
                        currentWeather.getWeather().get(0).getMain().contains("Rain")) {
                    weatherActivityBinding.includedSimilarLayout.totalViewLL.setBackgroundColor(getResources().getColor(R.color.rainy));
                    weatherActivityBinding.includedSimilarLayout.topViewLL.setBackgroundColor(getResources().getColor(R.color.rainy));
                    weatherActivityBinding.includedSimilarLayout.tempTV.setBackgroundResource(R.drawable.forest_rainy);
                } else if (currentWeather.getWeather().get(0).getMain().contains("Cloudy") ||
                        currentWeather.getWeather().get(0).getMain().contains("Clouds")) {
                    weatherActivityBinding.includedSimilarLayout.totalViewLL.setBackgroundColor(getResources().getColor(R.color.cloudy));
                    weatherActivityBinding.includedSimilarLayout.topViewLL.setBackgroundColor(getResources().getColor(R.color.cloudy));
                    weatherActivityBinding.includedSimilarLayout.tempTV.setBackgroundResource(R.drawable.forest_cloudy);
                } else {
                    weatherActivityBinding.includedSimilarLayout.totalViewLL.setBackgroundColor(getResources().getColor(R.color.sunny));
                    weatherActivityBinding.includedSimilarLayout.tempTV.setBackgroundResource(R.drawable.forest_sunny);
                }
                weatherActivityBinding.includedSimilarLayout.tempTV.setText(convertFahrenheitToCelsius(currentWeather.getMain().getTemp()));
                weatherActivityBinding.includedSimilarLayout.minTempTV.setText(convertFahrenheitToCelsius(currentWeather.getMain().getTempMin()));
                weatherActivityBinding.includedSimilarLayout.currentTempTV.setText(convertFahrenheitToCelsius(currentWeather.getMain().getTemp()));
                weatherActivityBinding.includedSimilarLayout.maxTempTV.setText(convertFahrenheitToCelsius(currentWeather.getMain().getTempMax()));
            }
        }

        if (object instanceof CurrentForecast) {
            CurrentForecast currentForecast = (CurrentForecast) object;
            if (currentForecast != null) {
                if (currentForecast.getList() != null)
                    forecastList = currentForecast.getList();

                ForecastWeatherListAdapter forecastWeatherListAdapter = (ForecastWeatherListAdapter) weatherActivityBinding.includedSimilarLayout.forecastList.getAdapter();
                forecastWeatherListAdapter.setForecastLists(forecastList);
            }
        }
    }

    private String convertFahrenheitToCelsius(Double temp) {
        Double b=temp-32;
        Double c=b*5/9;
        String r=String.format("%2f", c);
        String result = null;
        int index = r.indexOf('.');
        if (index >= 0) {
            result = r.substring(0, index+3);
        } else {
            result = r;
        }
        return result  + "°C";
    }

}
