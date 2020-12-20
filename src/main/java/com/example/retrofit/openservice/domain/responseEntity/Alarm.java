package com.example.retrofit.openservice.domain.responseEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Alarm{

	@JsonProperty("alarm_type")
	private String alarmType;

	@JsonProperty("alarm_content")
	private String alarmContent;

	@JsonProperty("alarm_level")
	private String alarmLevel;

}
