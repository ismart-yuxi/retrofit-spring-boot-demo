package com.example.retrofit.openservice.weather.service.remote.fallback;

import com.example.retrofit.openservice.weather.domain.responseEntity.Response;
import com.example.retrofit.openservice.weather.service.remote.HttpApi;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MultipartBody;
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

    /**
     * 上传时发生熔断
     * @param file 要上传的文件
     * @return
     */
    @Override
    public String upload(MultipartBody.Part file) {
        log.error("远程调用出现问题，熔断被启动");
        return null;
    }
}
