
package com.sample.weatherapp.model.Forecast;

import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("dt")
    private Integer dt;
    @SerializedName("main")
    private Main main;
    @SerializedName("weather")
    private java.util.List<Weather> weather = null;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("visibility")
    private Integer visibility;
    @SerializedName("pop")
    private Integer pop;
    @SerializedName("sys")
    private Sys sys;
    @SerializedName("dt_txt")
    private String dtTxt;

    @SerializedName("dt")
    public Integer getDt() {
        return dt;
    }

    @SerializedName("dt")
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    @SerializedName("main")
    public Main getMain() {
        return main;
    }

    @SerializedName("main")
    public void setMain(Main main) {
        this.main = main;
    }

    @SerializedName("weather")
    public java.util.List<Weather> getWeather() {
        return weather;
    }

    @SerializedName("weather")
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    @SerializedName("clouds")
    public Clouds getClouds() {
        return clouds;
    }

    @SerializedName("clouds")
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    @SerializedName("wind")
    public Wind getWind() {
        return wind;
    }

    @SerializedName("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @SerializedName("visibility")
    public Integer getVisibility() {
        return visibility;
    }

    @SerializedName("visibility")
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    @SerializedName("pop")
    public Integer getPop() {
        return pop;
    }

    @SerializedName("pop")
    public void setPop(Integer pop) {
        this.pop = pop;
    }

    @SerializedName("sys")
    public Sys getSys() {
        return sys;
    }

    @SerializedName("sys")
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    @SerializedName("dt_txt")
    public String getDtTxt() {
        return dtTxt;
    }

    @SerializedName("dt_txt")
    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

}
