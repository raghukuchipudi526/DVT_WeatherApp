
package com.sample.weatherapp.model.Forecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentForecast {

    @SerializedName("cod")
    private String cod;
    @SerializedName("message")
    private Integer message;
    @SerializedName("cnt")
    private Integer cnt;
    @SerializedName("list")
    private java.util.List<com.sample.weatherapp.model.Forecast.List> list = null;
    @SerializedName("city")
    private City city;

    @SerializedName("cod")
    public String getCod() {
        return cod;
    }

    @SerializedName("cod")
    public void setCod(String cod) {
        this.cod = cod;
    }

    @SerializedName("message")
    public Integer getMessage() {
        return message;
    }

    @SerializedName("message")
    public void setMessage(Integer message) {
        this.message = message;
    }

    @SerializedName("cnt")
    public Integer getCnt() {
        return cnt;
    }

    @SerializedName("cnt")
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    @SerializedName("list")
    public java.util.List<com.sample.weatherapp.model.Forecast.List> getList() {
        return list;
    }

    @SerializedName("list")
    public void setList(java.util.List<com.sample.weatherapp.model.Forecast.List> list) {
        this.list = list;
    }


    @SerializedName("city")
    public City getCity() {
        return city;
    }

    @SerializedName("city")
    public void setCity(City city) {
        this.city = city;
    }

}
