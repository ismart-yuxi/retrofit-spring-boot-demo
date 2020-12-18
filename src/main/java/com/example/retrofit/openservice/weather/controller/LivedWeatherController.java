package com.example.retrofit.openservice.weather.controller;

import com.example.retrofit.openservice.weather.domain.responseEntity.Response;
import com.example.retrofit.openservice.weather.service.LivedWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        livedWeatherService.uploadFile(file);
        return "success";
    }

}
