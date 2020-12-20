package com.example.retrofit.openservice.service.remote;

import com.example.retrofit.openservice.domain.responseEntity.postman.PostmanResponse;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

@RetrofitClient(baseUrl = "${example.postman-service.base-url}")
public interface PostmanApi {


    /**
     *
     * The HTTP POST request method is meant to transfer data to a server (and elicit a response). What data is returned depends on the implementation of the server.
     *
     * A POST request can pass parameters to the server using "Query String Parameters", as well as the Request Body. For example, in the following request,
     *
     * POST /hi/there?hand=wave
     *
     * The parameter "hand" has the value "wave". The request body can be in multiple formats. These formats are defined by the MIME type of the request. The MIME Type can be set using the Content-Type HTTP header. The most commonly used MIME types are:
     *
     * multipart/form-data
     * application/x-www-form-urlencoded
     * application/json
     * This endpoint echoes the HTTP headers, request parameters, the contents of the request body and the complete URI requested when data is sent as a form parameter.
     *
     * @param foo1
     * @param foo2
     * @return
     */
    @FormUrlEncoded
    @POST("post")
    PostmanResponse postmanpost(@Field("foo1") String foo1, @Field("foo2")String foo2);

}
