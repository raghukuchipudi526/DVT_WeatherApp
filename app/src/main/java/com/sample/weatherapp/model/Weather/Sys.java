
package com.sample.weatherapp.model.Weather;

import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("type")
    private Integer type;
    @SerializedName("id")
    private Integer id;
    @SerializedName("country")
    private String country;
    @SerializedName("sunrise")
    private Integer sunrise;
    @SerializedName("sunset")
    private Integer sunset;

    @SerializedName("type")
    public Integer getType() {
        return type;
    }

    @SerializedName("type")
    public void setType(Integer type) {
        this.type = type;
    }

    @SerializedName("id")
    public Integer getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @SerializedName("country")
    public String getCountry() {
        return country;
    }

    @SerializedName("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @SerializedName("sunrise")
    public Integer getSunrise() {
        return sunrise;
    }

    @SerializedName("sunrise")
    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    @SerializedName("sunset")
    public Integer getSunset() {
        return sunset;
    }

    @SerializedName("sunset")
    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }

}
