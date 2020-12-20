package com.example.retrofit.openservice.service;

import com.example.retrofit.openservice.domain.responseEntity.Response;
import com.example.retrofit.openservice.domain.responseEntity.life.LifeResponse;
import com.example.retrofit.openservice.service.remote.HttpApi;
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



    public LifeResponse lifeRepo(Map<String, String> requestParamMap) {
//        LifeRepoEntity lifeRepoEntity =  BeanUtil.toBean(requestParamMap, LifeRepoEntity.class);
        return httpApi.lifepro(requestParamMap);
    }

}
