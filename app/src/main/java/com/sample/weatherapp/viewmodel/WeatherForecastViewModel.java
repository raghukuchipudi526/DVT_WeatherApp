package com.sample.weatherapp.viewmodel;

import android.content.Context;
import android.widget.Toast;

import com.sample.weatherapp.AppController;
import com.sample.weatherapp.Constants;
import com.sample.weatherapp.model.Weather.CurrentWeather;
import com.sample.weatherapp.rest.RestApi;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class WeatherForecastViewModel extends AbstractViewModel implements Constants {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private Context context;
    private CurrentWeather currentWeather;
    private String latitude;
    private String longitude;

    public WeatherForecastViewModel(Context context, String latitude, String longitude) {
        this.context = context;
        this.currentWeather = new CurrentWeather();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public void initializeViews() {
    }

    @Override
    public void fetchData() {
        AppController appController = AppController.create(context);
        RestApi restApi = appController.getRestApi();

        Disposable ratingObservable = restApi.fetchCurrentWeather(latitude, longitude, API_KEY)
                .subscribeOn(appController.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccessResponse, this::onFailureResponse);
        compositeDisposable.add(ratingObservable);
    }

    @Override
    public void onSuccessResponse(Object object) {
        if (object instanceof CurrentWeather) {
            CurrentWeather weather = (CurrentWeather) object;
            if (weather != null)
                currentWeather = weather;
            refreshView(currentWeather);
        }
    }

    @Override
    public void onFailureResponse(Throwable t) {

    }
}
