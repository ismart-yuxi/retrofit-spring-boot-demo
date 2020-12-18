package com.example.retrofit.base;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BaseGlobalInterceptor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 系统全局拦截
 *
 * @author wangyuxi
 * @date 2020/12/09
 */
@Component
@Slf4j
public class SystemSourceGlobalInterceptor extends BaseGlobalInterceptor {

    @Override
    public Response doIntercept(Chain chain) throws IOException {
        log.info("====>SystemSourceGlobalInterceptor");
        Request request = chain.request();

        log.info("timestamp===>" + request.url().queryParameter("timestamp") + "=======>anotherTimeStampTimestamp====>" + request.url().queryParameter("anotherTimeStampTimestamp"));

        Request newReq = request.newBuilder()
                /*请求时加入信息*/
                .addHeader("source", "test")
                .build();
        return chain.proceed(newReq);
    }

}
