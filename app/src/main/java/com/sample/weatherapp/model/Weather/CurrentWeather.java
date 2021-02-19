
package com.sample.weatherapp.model.Weather;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentWeather {

    @SerializedName("coord")
    private Coord coord;
    @SerializedName("weather")
    private List<Weather> weather = null;
    @SerializedName("base")
    private String base;
    @SerializedName("main")
    private Main main;
    @SerializedName("visibility")
    private Integer visibility;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("dt")
    private Integer dt;
    @SerializedName("sys")
    private Sys sys;
    @SerializedName("timezone")
    private Integer timezone;
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("cod")
    private Integer cod;

    @SerializedName("coord")
    public Coord getCoord() {
        return coord;
    }

    @SerializedName("coord")
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @SerializedName("weather")
    public List<Weather> getWeather() {
        return weather;
    }

    @SerializedName("weather")
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    @SerializedName("base")
    public String getBase() {
        return base;
    }

    @SerializedName("base")
    public void setBase(String base) {
        this.base = base;
    }

    @SerializedName("main")
    public Main getMain() {
        return main;
    }

    @SerializedName("main")
    public void setMain(Main main) {
        this.main = main;
    }

    @SerializedName("visibility")
    public Integer getVisibility() {
        return visibility;
    }

    @SerializedName("visibility")
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    @SerializedName("wind")
    public Wind getWind() {
        return wind;
    }

    @SerializedName("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @SerializedName("clouds")
    public Clouds getClouds() {
        return clouds;
    }

    @SerializedName("clouds")
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    @SerializedName("dt")
    public Integer getDt() {
        return dt;
    }

    @SerializedName("dt")
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    @SerializedName("sys")
    public Sys getSys() {
        return sys;
    }

    @SerializedName("sys")
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    @SerializedName("timezone")
    public Integer getTimezone() {
        return timezone;
    }

    @SerializedName("timezone")
    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

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

    @SerializedName("cod")
    public Integer getCod() {
        return cod;
    }

    @SerializedName("cod")
    public void setCod(Integer cod) {
        this.cod = cod;
    }

}
