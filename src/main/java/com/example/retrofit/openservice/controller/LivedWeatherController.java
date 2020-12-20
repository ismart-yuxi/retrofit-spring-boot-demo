package com.example.retrofit.openservice.controller;

import com.example.retrofit.openservice.domain.responseEntity.Response;
import com.example.retrofit.openservice.domain.responseEntity.life.LifeResponse;
import com.example.retrofit.openservice.service.LivedWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wangyuxi
 * @date 2020/08/24
 **/
@RestController
@RequestMapping("/weather")
public class LivedWeatherController {

    @Autowired
    private LivedWeatherService livedWeatherService;

    @GetMapping("/livedWeather")
    public Response livedWeather(@RequestParam Map<String, String> requestParamMap) {
        return livedWeatherService.livedWeather(requestParamMap);
    }


    /*
    * 专业31项生活指数预报
    * */
    @GetMapping("/life/lifeRepo")
    public LifeResponse lifeRepo(@RequestParam Map<String, String> requestParamMap) {
        return livedWeatherService.lifeRepo(requestParamMap);
    }

}
