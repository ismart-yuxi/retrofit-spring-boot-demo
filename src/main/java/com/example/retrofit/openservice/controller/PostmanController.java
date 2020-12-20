package com.example.retrofit.openservice.controller;

import com.example.retrofit.openservice.domain.responseEntity.postman.PostmanResponse;
import com.example.retrofit.openservice.service.PostmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postman")
public class PostmanController {


    @Autowired
    private PostmanService postmanService;


    @PostMapping("/post")
    public PostmanResponse upload(@RequestParam(value = "foo1") String foo1, @RequestParam(value = "foo2")String foo2) {
        return postmanService.post( foo1,foo2);
    }
}
