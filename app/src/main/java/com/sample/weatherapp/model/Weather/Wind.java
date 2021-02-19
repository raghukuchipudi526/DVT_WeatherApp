
package com.sample.weatherapp.model.Weather;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    private Double speed;
    @SerializedName("deg")
    private Integer deg;

    @SerializedName("speed")
    public Double getSpeed() {
        return speed;
    }

    @SerializedName("speed")
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @SerializedName("deg")
    public Integer getDeg() {
        return deg;
    }

    @SerializedName("deg")
    public void setDeg(Integer deg) {
        this.deg = deg;
    }

}
