package com.example.retrofit.ext;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import lombok.Data;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Data
public class SignInterceptor extends BasePathMatchInterceptor {

    private String accessKeyId;

    private String accessKeySecret;

    @Override
    public Response doIntercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request newReq = request.newBuilder()
            .addHeader("accessKeyId", accessKeyId)
            .addHeader("accessKeySecret", accessKeySecret)
            .build();
        return chain.proceed(newReq);
    }
}
