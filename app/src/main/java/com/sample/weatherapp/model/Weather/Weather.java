
package com.sample.weatherapp.model.Weather;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("id")
    private Integer id;
    @SerializedName("main")
    private String main;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;

    @SerializedName("id")
    public Integer getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @SerializedName("main")
    public String getMain() {
        return main;
    }

    @SerializedName("main")
    public void setMain(String main) {
        this.main = main;
    }

    @SerializedName("description")
    public String getDescription() {
        return description;
    }

    @SerializedName("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("icon")
    public String getIcon() {
        return icon;
    }

    @SerializedName("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

}
