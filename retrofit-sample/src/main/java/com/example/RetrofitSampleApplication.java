package com.example;

import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
@SpringBootApplication
@Slf4j
public class RetrofitSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(RetrofitSampleApplication.class, args);
    }

    @Bean
    @Primary
    OkHttpClient defaultBaseOkHttpClient() {
        return new OkHttpClient.Builder()
            .addInterceptor(chain -> {
                log.info("=======替换默认的BaseOkHttpClient=====");
                return chain.proceed(chain.request());
            })
            .build();
    }

    @Bean
    OkHttpClient testOkHttpClient() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(100);
        dispatcher.setMaxRequestsPerHost(10);

        return new OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .dispatcher(dispatcher)
            .connectionPool(new ConnectionPool(10, 10, TimeUnit.MINUTES))
            .addInterceptor(chain -> {
                log.info("=======使用testOkHttpClientBuilder构建的OkHttpClient=====");
                return chain.proceed(chain.request());
            })
            .build();
    }
}
