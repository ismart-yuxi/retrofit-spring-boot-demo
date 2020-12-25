package com.example.openservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * 演示动态url 请求
 *
 */
@Slf4j
@RestController
@RequestMapping("/openservice/")
public class DynamicUrlController {


    @GetMapping("/dynamic1/url1/")
    public Map<String, Object>  dynamicUrl1(String name) {
        Map<String, Object> map = new HashMap<>();
        map.clear();
        map.put("dynamicUrl1","/dynamic1/url1/"+name);
        return map;
    }

    @GetMapping("/dynamic2/url2/")
    public Map<String, Object>  dynamicUrl2(String name) {
        Map<String, Object> map = new HashMap<>();
        map.clear();
        map.put("dynamicUrl2","/dynamic2/url2/"+name);
        return map;
    }
}
