package com.example.retrofit.openservice.weather.service.remote;

import com.example.retrofit.base.Sign;
import com.example.retrofit.openservice.weather.domain.responseEntity.Response;
import com.example.retrofit.openservice.weather.service.remote.fallback.HttpDegradeFallback;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 *
 * 2.2.0 增加熔断器
 *  https://github.com/LianjiaTech/retrofit-spring-boot-starter#%E7%86%94%E6%96%AD%E9%99%8D%E7%BA%A7
 *
 * @author wangyuxi
 * @date 2020/08/24
 **/
@RetrofitClient(baseUrl = "https://tianqiapi.com/",fallback = HttpDegradeFallback.class)
@Sign
public interface HttpApi {

    /**
     * 构建出的这个方法一定一定要加  @OkHttpClientBuilder 这个注解
     * @return
     */
//    @OkHttpClientBuilder
//    static OkHttpClient.Builder okhttpClientBuilder() {
//        return new OkHttpClient.Builder()
//                .connectTimeout(1, TimeUnit.SECONDS)
//                .readTimeout(1, TimeUnit.SECONDS)
//                .writeTimeout(1, TimeUnit.SECONDS);
//
//    }

    /**
     *  方法上的路径不以/开头
     *
     *  对于Retrofit而言，方法上的/开头表示直接接在domain后面的端点。
     *
     */
    @GET("api")
    Response api(@QueryMap Map<String, String> livedWeather);
}
