package com.example.retrofit.openservice.service.remote.fallback;

import com.example.retrofit.openservice.domain.responseEntity.Response;
import com.example.retrofit.openservice.domain.responseEntity.life.LifeResponse;
import com.example.retrofit.openservice.service.remote.HttpApi;
import com.github.lianjiatech.retrofit.spring.boot.degrade.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wangyuxi
 * @date 2020/11/10
 **/
@Component
@Slf4j
public class HttpDegradeFallbackFactory implements FallbackFactory<HttpApi> {

    /**
     * Returns an instance of the fallback appropriate for the given cause
     *
     * @param cause fallback cause
     * @return 实现了retrofit接口的实例。an instance that implements the retrofit interface.
     */
    @Override
    public HttpApi create(Throwable cause) {
        log.error("触发熔断了! ", cause.getMessage(), cause);
        return new HttpApi() {

            @Override
            public Response api(Map<String, String> livedWeather) {
                return null;
            }

            @Override
            public LifeResponse lifepro(Map<String, String> requestParamMap) {
                return null;
            }
        };
    }
}
