package com.sample.weatherapp.viewmodel;

import android.content.Context;
import android.widget.Toast;

import com.sample.weatherapp.AppController;
import com.sample.weatherapp.Constants;
import com.sample.weatherapp.model.Forecast.CurrentForecast;
import com.sample.weatherapp.rest.RestApi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class ForecastViewModel extends AbstractViewModel implements Constants {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private Context context;
    private CurrentForecast currentForecast;
    private String latitude;
    private String longitude;

    public ForecastViewModel(Context context, String latitude, String longitude) {
        this.context = context;
        this.currentForecast = new CurrentForecast();
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

        Disposable ratingObservable = restApi.fetchFiveDayForecast(latitude, longitude, API_KEY)
                .subscribeOn(appController.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccessResponse, this::onFailureResponse);
        compositeDisposable.add(ratingObservable);
    }

    @Override
    public void onSuccessResponse(Object object) {
        if (object instanceof CurrentForecast) {
            CurrentForecast forecast = (CurrentForecast) object;
            if (forecast != null)
                currentForecast = forecast;
            refreshView(forecast);
        }
    }

    @Override
    public void onFailureResponse(Throwable t) {
        Toast.makeText(context, "Five day forecast service is failing.", Toast.LENGTH_SHORT).show();
    }
}

