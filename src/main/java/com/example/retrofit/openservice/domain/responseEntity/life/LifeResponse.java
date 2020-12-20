package com.example.retrofit.openservice.domain.responseEntity.life;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LifeResponse{

	@JsonProperty("update_time")
	private String updateTime;

	@JsonProperty("data")
	private Data data;

	@JsonProperty("city")
	private String city;

	@JsonProperty("cityid")
	private String cityid;

	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}

	public String getUpdateTime(){
		return updateTime;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setCityid(String cityid){
		this.cityid = cityid;
	}

	public String getCityid(){
		return cityid;
	}

	@Override
 	public String toString(){
		return
			"LifeResponse{" +
			"update_time = '" + updateTime + '\'' +
			",data = '" + data + '\'' +
			",city = '" + city + '\'' +
			",cityid = '" + cityid + '\'' +
			"}";
		}
}
