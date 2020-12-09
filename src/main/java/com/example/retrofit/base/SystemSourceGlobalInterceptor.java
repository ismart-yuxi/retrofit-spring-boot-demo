package com.example.retrofit.base;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BaseGlobalInterceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 *
 * 系统全局拦截
 *
 * @author wangyuxi
 * @date 2020/12/09
 *
 */
@Component
public class SystemSourceGlobalInterceptor extends BaseGlobalInterceptor {

    @Override
    public Response doIntercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newReq = request.newBuilder()
            /*请求时加入信息*/
            .addHeader("source", "test")
            .build();
        return chain.proceed(newReq);
    }

}
