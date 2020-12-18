package com.example.retrofit.base;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class AnotherTimeStampInterceptor extends BasePathMatchInterceptor {

    @Override
    public Response doIntercept(Chain chain) throws IOException {
        log.info("====>AnotherTimeStampInterceptor");
        Request request = chain.request();
        HttpUrl url = request.url();
        long timestamp = System.nanoTime();
        HttpUrl newUrl = url.newBuilder()
                .addQueryParameter("anotherTimeStampTimestamp", String.valueOf(timestamp))
                .build();
        Request newRequest = request.newBuilder()
                .url(newUrl)
                .build();
        return chain.proceed(newRequest);
    }
}
