package com.example.retrofit.openservice.weather.service;

import com.example.retrofit.openservice.weather.domain.responseEntity.Response;
import com.example.retrofit.openservice.weather.service.remote.HttpApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wangyuxi
 * @date 2020/08/24
 **/
@Service
public class LivedWeatherService {

    @Autowired
    private HttpApi httpApi;

    public Response livedWeather(Map<String, String> requestParamMap) {
        return httpApi.api(requestParamMap);
    }
}
