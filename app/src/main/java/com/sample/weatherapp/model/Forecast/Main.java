
package com.sample.weatherapp.model.Forecast;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    private Double temp;
    @SerializedName("feels_like")
    private Double feelsLike;
    @SerializedName("temp_min")
    private Double tempMin;
    @SerializedName("temp_max")
    private Double tempMax;
    @SerializedName("pressure")
    private Integer pressure;
    @SerializedName("sea_level")
    private Integer seaLevel;
    @SerializedName("grnd_level")
    private Integer grndLevel;
    @SerializedName("humidity")
    private Integer humidity;
    @SerializedName("temp_kf")
    private Integer tempKf;

    @SerializedName("temp")
    public Double getTemp() {
        return temp;
    }

    @SerializedName("temp")
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    @SerializedName("feels_like")
    public Double getFeelsLike() {
        return feelsLike;
    }

    @SerializedName("feels_like")
    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }

    @SerializedName("temp_min")
    public Double getTempMin() {
        return tempMin;
    }

    @SerializedName("temp_min")
    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    @SerializedName("temp_max")
    public Double getTempMax() {
        return tempMax;
    }

    @SerializedName("temp_max")
    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    @SerializedName("pressure")
    public Integer getPressure() {
        return pressure;
    }

    @SerializedName("pressure")
    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    @SerializedName("sea_level")
    public Integer getSeaLevel() {
        return seaLevel;
    }

    @SerializedName("sea_level")
    public void setSeaLevel(Integer seaLevel) {
        this.seaLevel = seaLevel;
    }

    @SerializedName("grnd_level")
    public Integer getGrndLevel() {
        return grndLevel;
    }

    @SerializedName("grnd_level")
    public void setGrndLevel(Integer grndLevel) {
        this.grndLevel = grndLevel;
    }

    @SerializedName("humidity")
    public Integer getHumidity() {
        return humidity;
    }

    @SerializedName("humidity")
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @SerializedName("temp_kf")
    public Integer getTempKf() {
        return tempKf;
    }

    @SerializedName("temp_kf")
    public void setTempKf(Integer tempKf) {
        this.tempKf = tempKf;
    }


}
