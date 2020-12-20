package com.example.retrofit.openservice.domain.responseEntity.postman;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Headers implements Serializable {

	@JsonProperty("content-length")
	private String contentLength;

	@JsonProperty("x-amzn-trace-id")
	private String xAmznTraceId;

	@JsonProperty("x-forwarded-proto")
	private String xForwardedProto;

	@JsonProperty("postman-token")
	private String postmanToken;

	@JsonProperty("host")
	private String host;

	@JsonProperty("x-forwarded-port")
	private String xForwardedPort;

	@JsonProperty("content-type")
	private String contentType;

	@JsonProperty("cache-control")
	private String cacheControl;

	@JsonProperty("accept-encoding")
	private String acceptEncoding;

	@JsonProperty("user-agent")
	private String userAgent;

	@JsonProperty("accept")
	private String accept;

	public void setContentLength(String contentLength){
		this.contentLength = contentLength;
	}

	public String getContentLength(){
		return contentLength;
	}

	public void setXAmznTraceId(String xAmznTraceId){
		this.xAmznTraceId = xAmznTraceId;
	}

	public String getXAmznTraceId(){
		return xAmznTraceId;
	}

	public void setXForwardedProto(String xForwardedProto){
		this.xForwardedProto = xForwardedProto;
	}

	public String getXForwardedProto(){
		return xForwardedProto;
	}

	public void setPostmanToken(String postmanToken){
		this.postmanToken = postmanToken;
	}

	public String getPostmanToken(){
		return postmanToken;
	}

	public void setHost(String host){
		this.host = host;
	}

	public String getHost(){
		return host;
	}

	public void setXForwardedPort(String xForwardedPort){
		this.xForwardedPort = xForwardedPort;
	}

	public String getXForwardedPort(){
		return xForwardedPort;
	}

	public void setContentType(String contentType){
		this.contentType = contentType;
	}

	public String getContentType(){
		return contentType;
	}

	public void setCacheControl(String cacheControl){
		this.cacheControl = cacheControl;
	}

	public String getCacheControl(){
		return cacheControl;
	}

	public void setAcceptEncoding(String acceptEncoding){
		this.acceptEncoding = acceptEncoding;
	}

	public String getAcceptEncoding(){
		return acceptEncoding;
	}

	public void setUserAgent(String userAgent){
		this.userAgent = userAgent;
	}

	public String getUserAgent(){
		return userAgent;
	}

	public void setAccept(String accept){
		this.accept = accept;
	}

	public String getAccept(){
		return accept;
	}
}
