
package com.sample.weatherapp.model.Forecast;

import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("pod")
    private String pod;

    @SerializedName("pod")
    public String getPod() {
        return pod;
    }

    @SerializedName("pod")
    public void setPod(String pod) {
        this.pod = pod;
    }

}
