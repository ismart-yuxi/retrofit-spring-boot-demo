package com.example.retrofit.openservice.service.remote;

import com.example.retrofit.base.AnotherTimeStampInterceptor;
import com.example.retrofit.base.Sign;
import com.example.retrofit.base.TimeStampInterceptor;
import com.example.retrofit.openservice.domain.responseEntity.Response;
import com.example.retrofit.openservice.domain.responseEntity.life.LifeResponse;
import com.example.retrofit.openservice.service.remote.fallback.HttpDegradeFallback;
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
@RetrofitClient(baseUrl = "${example.weather-service.base-url}",fallback = HttpDegradeFallback.class)
/*拦截器顺序为标记的顺序，其中全局过滤器排在最后*/

@Sign
/*2.2.2  @Intercept支持多拦截器配置*/
@Intercept(handler = TimeStampInterceptor.class, include = {"/api/**"})
@Intercept(handler = AnotherTimeStampInterceptor.class, include = {"/api/**"})

/**
 * 请求重试
 * retrofit-spring-boot-starter支持请求重试功能，只需要在接口或者方法上加上@Retry注解即可。
 * @Retry支持重试次数maxRetries、重试时间间隔intervalMs以及重试规则retryRules配置。重试规则支持三种配置：
 *
 * RESPONSE_STATUS_NOT_2XX：响应状态码不是2xx时执行重试；
 * OCCUR_IO_EXCEPTION：发生IO异常时执行重试；
 * OCCUR_EXCEPTION：发生任意异常时执行重试；
 * 默认响应状态码不是2xx或者发生IO异常时自动进行重试。需要的话，你也可以继承BaseRetryInterceptor实现自己的请求重试拦截器，然后将其配置上去。
 *
 * 请更改操作系统 host 127.0.0.1 tianqiapi.com  跟进作者在重试拦截器中加入重试调试日志的输出
 */
@Retry
public interface HttpApi {

    /**
     * 构建出的这个方法一定一定要加  @OkHttpClientBuilder 这个注解
     *
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
     * 方法上的路径不以/开头
     * <p>
     * 对于Retrofit而言，方法上的/开头表示直接接在domain后面的端点。
     */
    @GET("api")
    /* @Retry 也可加载接口上 */
    Response api(@QueryMap Map<String, String> livedWeather);


/*

根据国内城市区域代码获取国内1天的生活指数预报信息，直连中央气象局数据，每天更新12次。
含：空调开启指数、过敏指数、晨练指数、舒适度指数、穿衣指数、钓鱼指数、防晒指数、逛街指数、太阳镜指数、感冒指数、干燥指数、划船指数、交通指数、路况指数
、晾晒指数、美发指数、夜生活指数、啤酒指数、放风筝指数、空气污染扩散条件指数、
化妆指数、旅游指数、紫外线强度指数、风寒指数、洗车指数、心情指数、运动指数、约会指数、雨伞指数、中暑指数、戴口罩指数。



| 参数名       | 必选 | 类型     | 说明          | 备注（示例）                          |
        |-----------|----|--------|-------------|---------------------------------|
        | appid     | 是  | string | 用户appid     | 注册开发账号                          |
        | appsecret | 是  | string | 用户appsecret |                                 |
        | cityid    | 否  | string | 城市ID        | 请参考 城市ID列表                      |
        | city      | 否  | string | 城市名称        | 不要带市和区; 如: 青岛、铁西                |
        | ip        | 否  | string | IP地址        | 查询IP所在城市天气                      |
        | callback  | 否  | string | jsonp参数     | 如: jQuery\.Callbacks            |
        | vue       | 否  | string | 跨域参数        | 如果您使用的是react、vue、angular请填写值: 1 |
*/
    @GET("life/lifepro")
    LifeResponse lifepro(@QueryMap Map<String, String> requestParamMap);



}
