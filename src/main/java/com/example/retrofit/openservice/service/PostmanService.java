package com.example.retrofit.openservice.service;

import com.example.retrofit.openservice.domain.responseEntity.postman.PostmanResponse;
import com.example.retrofit.openservice.service.remote.PostmanApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostmanService {

    @Autowired
    private PostmanApi httpApi;

    public PostmanResponse post(String foo1, String foo2) {
       return httpApi.postmanpost(foo1,foo2);
    }
}
