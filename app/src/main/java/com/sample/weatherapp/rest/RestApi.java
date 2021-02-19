package com.sample.weatherapp.rest;

import com.sample.weatherapp.model.Forecast.CurrentForecast;
import com.sample.weatherapp.model.Weather.CurrentWeather;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RestApi {

    @GET("weather")
    Observable<CurrentWeather> fetchCurrentWeather(@Query("lat") String latitude,
                                                   @Query("lon") String longitude,
                                                   @Query("appid") String apiKey);

    @GET("forecast")
    Observable<CurrentForecast> fetchFiveDayForecast(@Query("lat") String latitude,
                                                     @Query("lon") String longitude,
                                                     @Query("appid") String apiKey);

}
