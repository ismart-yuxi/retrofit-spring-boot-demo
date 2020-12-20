package com.example.retrofit.openservice.service.remote.fallback;

import com.example.retrofit.openservice.domain.responseEntity.Response;
import com.example.retrofit.openservice.domain.responseEntity.life.LifeResponse;
import com.example.retrofit.openservice.service.remote.HttpApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wangyuxi
 * @date 2020/11/10
 **/
@Slf4j
@Service
public class HttpDegradeFallback implements HttpApi {

    /**
     * 发生熔断时，返回无天气预报信息
     *
     * @param livedWeather
     * @return
     */
    @Override
    public Response api(Map<String, String> livedWeather) {
        log.error("远程调用出现问题，熔断被启动");
        return null;
    }

    @Override
    public LifeResponse lifepro(Map<String, String> requestParamMap) {
        log.error("远程调用出现问题，熔断被启动");
        return null;
    }

}
