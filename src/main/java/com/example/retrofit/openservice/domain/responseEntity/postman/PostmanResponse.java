package com.example.retrofit.openservice.domain.responseEntity.postman;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties
public class PostmanResponse implements Serializable {

	@JsonProperty("args")
	private Args args;

	@JsonProperty("headers")
	private Headers headers;

	@JsonProperty("data")
	private Data data;

	@JsonProperty("form")
	private Form form;

	@JsonProperty("files")
	private Files files;

	@JsonProperty("json")
	private Object json;

	@JsonProperty("url")
	private String url;

	public void setArgs(Args args){
		this.args = args;
	}

	public Args getArgs(){
		return args;
	}

	public void setHeaders(Headers headers){
		this.headers = headers;
	}

	public Headers getHeaders(){
		return headers;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setForm(Form form){
		this.form = form;
	}

	public Form getForm(){
		return form;
	}

	public void setFiles(Files files){
		this.files = files;
	}

	public Files getFiles(){
		return files;
	}

	public void setJson(Object json){
		this.json = json;
	}

	public Object getJson(){
		return json;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}
