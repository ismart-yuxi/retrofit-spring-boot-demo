package com.example.retrofit.openservice.domain.responseEntity.life;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Kouzhao{

	@JsonProperty("level")
	private String level;

	@JsonProperty("name")
	private String name;

	@JsonProperty("desc")
	private String desc;

	public void setLevel(String level){
		this.level = level;
	}

	public String getLevel(){
		return level;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDesc(String desc){
		this.desc = desc;
	}

	public String getDesc(){
		return desc;
	}

	@Override
 	public String toString(){
		return
			"Kouzhao{" +
			"level = '" + level + '\'' +
			",name = '" + name + '\'' +
			",desc = '" + desc + '\'' +
			"}";
		}
}
