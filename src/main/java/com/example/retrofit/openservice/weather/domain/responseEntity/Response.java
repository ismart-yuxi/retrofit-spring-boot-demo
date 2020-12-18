package com.example.retrofit.openservice.weather.domain.responseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    @JsonProperty("date")
    private String date;

    @JsonProperty("countryEn")
    private String countryEn;

    @JsonProperty("tem2")
    private String tem2;

    @JsonProperty("country")
    private String country;

    @JsonProperty("win_meter")
    private String winMeter;

    @JsonProperty("air_level")
    private String airLevel;

    @JsonProperty("week")
    private String week;

    @JsonProperty("tem1")
    private String tem1;

    @JsonProperty("visibility")
    private String visibility;

    @JsonProperty("city")
    private String city;

    @JsonProperty("cityid")
    private String cityid;

    @JsonProperty("pressure")
    private String pressure;

    @JsonProperty("air")
    private String air;

    @JsonProperty("air_pm25")
    private String airPm25;

    @JsonProperty("update_time")
    private String updateTime;

    @JsonProperty("wea")
    private String wea;

    @JsonProperty("air_tips")
    private String airTips;

    @JsonProperty("wea_img")
    private String weaImg;

    @JsonProperty("alarm")
    private Alarm alarm;

    @JsonProperty("cityEn")
    private String cityEn;

    @JsonProperty("win_speed")
    private String winSpeed;

    @JsonProperty("humidity")
    private String humidity;

    @JsonProperty("tem")
    private String tem;

    @JsonProperty("win")
    private String win;

}
