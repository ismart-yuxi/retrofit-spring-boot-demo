package com.example.retrofit.base;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static java.lang.System.out;

/**
 * @author wangyuxi
 * @date 2020/08/24
 **/
@Component
@Data
@Slf4j
public class SignInterceptor extends BasePathMatchInterceptor {

    @Value("${example.accessKeyId}")
    private String accessKeyId;
    @Value("${example.accessKeySecret}")
    private String accessKeySecret;

    @Override
    public Response doIntercept(Chain chain) throws IOException {
        log.info("====>SignInterceptor");
        Request request = chain.request();

        HttpUrl url = request.url();
        HttpUrl newUrl = url.newBuilder()
            .addQueryParameter("appid", accessKeyId)
            .addQueryParameter("appsecret", accessKeySecret)
            .build();
        Request newRequest = request.newBuilder()
            .url(newUrl)
            .build();

        request.url().queryParameterNames().forEach(param -> {

            out.print(param + "============" + request.url().queryParameterValues(param));
        });
        out.println();
        return chain.proceed(newRequest);
    }

}
