
package com.sample.weatherapp.model.Forecast;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class City {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("coord")
    private Coord coord;
    @SerializedName("country")
    private String country;
    @SerializedName("population")
    private Integer population;
    @SerializedName("timezone")
    private Integer timezone;
    @SerializedName("sunrise")
    private Integer sunrise;
    @SerializedName("sunset")
    private Integer sunset;

    @SerializedName("id")
    public Integer getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @SerializedName("name")
    public String getName() {
        return name;
    }

    @SerializedName("name")
    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("coord")
    public Coord getCoord() {
        return coord;
    }

    @SerializedName("coord")
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @SerializedName("country")
    public String getCountry() {
        return country;
    }

    @SerializedName("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @SerializedName("population")
    public Integer getPopulation() {
        return population;
    }

    @SerializedName("population")
    public void setPopulation(Integer population) {
        this.population = population;
    }

    @SerializedName("timezone")
    public Integer getTimezone() {
        return timezone;
    }

    @SerializedName("timezone")
    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
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

}
