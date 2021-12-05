package com.example.retrofit.remote;


import com.example.retrofit.domain.User;
import com.example.retrofit.ext.Sign;
import com.example.retrofit.remote.fallback.HttpApiFallback;
import com.example.retrofit.remote.fallback.HttpDegradeFallbackFactory;
import com.github.lianjiatech.retrofit.spring.boot.annotation.OkHttpClientBuilder;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.degrade.Degrade;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.LogStrategy;
import com.github.lianjiatech.retrofit.spring.boot.retry.Retry;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * v2.2.0 增加熔断器
 * v2.2.14 未配置baseUrl并且未配置serviceId忽视该接口注册(baseurl 和 serviceId 必选一个)
 * v2.2.15 ========> 2.1.13和2.2.14对于配置中心有bug，回退到2.2.12版本或升级到2.2.17
 * v2.2.16 默认关闭全局请求重试
 * v2.2.17 修复RetrofitClient在Apollo配置中心出现的bug(其中@RetrofitClient去掉@service注解)
 *
 *
 * https://github.com/LianjiaTech/retrofit-spring-boot-starter#%E7%86%94%E6%96%AD%E9%99%8D%E7%BA%A7
 *
 * @author wangyuxi
 * @date 2020/08/24
 **/

/*
 *
 *   拦截器顺序为标记的顺序，其中全局过滤器排在最后
 *
 *
 */

//@Sign
///*2.2.2  @Intercept支持多拦截器配置*/
//@Intercept(handler = TimeStampInterceptor.class, include = {"/api/**"})
//@Intercept(handler = AnotherTimeStampInterceptor.class, include = {"/api/**"})

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
 *
 * logStrategy = LogStrategy.BODY  把请求第三方接口的收到的返回值,打印出日志
 *
 */
@Retry
@RetrofitClient(baseUrl = "${test.baseUrl}",
    fallback = HttpApiFallback.class,
    fallbackFactory = HttpDegradeFallbackFactory.class,
    logStrategy = LogStrategy.BODY
)
@Sign(accessKeyId = "${test.accessKeyId}", accessKeySecret = "${test.accessKeySecret}")

/*默认策略情况下，每5s平均响应时间不得超过500ms，否则启用熔断降级*/
@Degrade(count = 500)
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
     * <p> @Query("id") Long id </p>
     * 对于Retrofit而言，方法上的/开头表示直接接在domain后面的端点。
     */
    @GET("user/{id}")
    Response<User> user(@Path("id") Long id);

    @GET("user")
    Call<List<User>> users();

    @POST("user")
    Call<ResponseBody> addUser(@Body User user);

    @PUT("user")
    Call<ResponseBody> updateUser(@Body User user);

    @DELETE("user/{id}")
    Call<ResponseBody> deleteUser(@Path("id") Long id);

    @POST("upload")
    @Multipart
    Call<ResponseBody> upload(@Part MultipartBody.Part file);

    /**
     * 使用@url注解可实现动态URL。
     *
     * 注意：@url必须放在方法参数的第一个位置。原有定义@GET、@POST等注解上，不需要定义端点路径！
     *
     * @param url
     * @param name
     * @return
     */
    @GET
    Response<Map<String, Object>> dynamicUrl(@Url String url, @Query("name") String name);


    /**
     * 调用下载
     * @return Response<ResponseBody>
     */
    @GET("download")
    Response<ResponseBody> download();

    /**
     * v2.2.10 支持基础类型(`String`/`Long`/`Integer`/`Boolean`/`Float`/`Double`)作为接口返回值
     * @param user
     * @return
     */
    @GET("returnValueString")
    String returnValueString();

    /**
     * v2.2.10 支持基础类型(`String`/`Long`/`Integer`/`Boolean`/`Float`/`Double`)作为接口返回值
     * @param user
     * @return
     */
    @GET("returnValueBoolean")
    Boolean returnValueBoolean();
}
