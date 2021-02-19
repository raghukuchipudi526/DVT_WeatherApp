
package com.sample.weatherapp.model.Weather;

import com.google.gson.annotations.SerializedName;

public class Clouds {

    @SerializedName("all")
    private Integer all;

    @SerializedName("all")
    public Integer getAll() {
        return all;
    }

    @SerializedName("all")
    public void setAll(Integer all) {
        this.all = all;
    }

}
