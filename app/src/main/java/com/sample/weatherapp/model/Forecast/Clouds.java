
package com.sample.weatherapp.model.Forecast;


import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

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
