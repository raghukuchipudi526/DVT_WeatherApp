
package com.sample.weatherapp.model.Forecast;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Coord {

    @SerializedName("lat")
    private Double lat;
    @SerializedName("lon")
    private Double lon;

    @SerializedName("lat")
    public Double getLat() {
        return lat;
    }

    @SerializedName("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @SerializedName("lon")
    public Double getLon() {
        return lon;
    }

    @SerializedName("lon")
    public void setLon(Double lon) {
        this.lon = lon;
    }

}
