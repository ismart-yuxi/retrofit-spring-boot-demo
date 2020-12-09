package com.example.retrofit.openservice.weather.service.remote;

import com.example.retrofit.base.AnotherTimeStampInterceptor;
import com.example.retrofit.base.Sign;
import com.example.retrofit.base.TimeStampInterceptor;
import com.example.retrofit.openservice.weather.domain.responseEntity.Response;
import com.example.retrofit.openservice.weather.service.remote.fallback.HttpDegradeFallback;
import com.github.lianjiatech.retrofit.spring.boot.annotation.Intercept;
import com.github.lianjiatech.retrofit.spring.boot.annotation.OkHttpClientBuilder;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.retry.Retry;
import okhttp3.OkHttpClient;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * 2.2.0 增加熔断器
 *  https://github.com/LianjiaTech/retrofit-spring-boot-starter#%E7%86%94%E6%96%AD%E9%99%8D%E7%BA%A7
 *
 * @author wangyuxi
 * @date 2020/08/24
 **/
@RetrofitClient(baseUrl = "https://tianqiapi.com/",fallback = HttpDegradeFallback.class)


/*拦截器顺序为标记的顺序，其中全局过滤器排在最后*/

@Sign
/*2.2.2  @Intercept支持多拦截器配置*/
@Intercept(handler = TimeStampInterceptor.class, include = {"/api/**"})
@Intercept(handler = AnotherTimeStampInterceptor.class, include = {"/api/**"})

/*请求重试
retrofit-spring-boot-starter支持请求重试功能，只需要在接口或者方法上加上@Retry注解即可。
@Retry支持重试次数maxRetries、重试时间间隔intervalMs以及重试规则retryRules配置。重试规则支持三种配置：

RESPONSE_STATUS_NOT_2XX：响应状态码不是2xx时执行重试；
OCCUR_IO_EXCEPTION：发生IO异常时执行重试；
OCCUR_EXCEPTION：发生任意异常时执行重试；
默认响应状态码不是2xx或者发生IO异常时自动进行重试。需要的话，你也可以继承BaseRetryInterceptor实现自己的请求重试拦截器，然后将其配置上去。*/
@Retry
public interface HttpApi {

    /**
     * 构建出的这个方法一定一定要加  @OkHttpClientBuilder 这个注解
     * @return
     */
    @OkHttpClientBuilder
    static OkHttpClient.Builder okhttpClientBuilder() {
        return new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.SECONDS);

    }

    /**
     *  方法上的路径不以/开头
     *
     *  对于Retrofit而言，方法上的/开头表示直接接在domain后面的端点。
     *
     */
    @GET("api")
    Response api(@QueryMap Map<String, String> livedWeather);
}
