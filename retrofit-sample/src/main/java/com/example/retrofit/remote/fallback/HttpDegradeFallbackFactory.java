package com.example.retrofit.remote.fallback;

import com.example.retrofit.domain.User;
import com.example.retrofit.remote.HttpApi;
import com.github.lianjiatech.retrofit.spring.boot.degrade.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Component
@Slf4j
public class HttpDegradeFallbackFactory  implements FallbackFactory<HttpApi> {
    @Override
    public HttpApi create(Throwable cause) {
        log.error("触发熔断了! {0} {1}", cause.getMessage(), cause);
        return new HttpApi() {
            @Override
            public Response<User> user(Long id) {
                return null;
            }

            @Override
            public Call<List<User>> users() {
                return null;
            }

            @Override
            public Call<ResponseBody> addUser(User user) {
                return null;
            }

            @Override
            public Call<ResponseBody> updateUser(User user) {
                return null;
            }

            @Override
            public Call<ResponseBody> deleteUser(Long id) {
                return null;
            }

            @Override
            public Call<ResponseBody> upload(MultipartBody.Part file) {
                return null;
            }

            @Override
            public Response<Map<String, Object>> dynamicUrl(String url, String name) {
                return null;
            }

            @Override
            public Response<ResponseBody> download() {
                return null;
            }

            @Override
            public String returnValueString() {
                return null;
            }

            @Override
            public Boolean returnValueBoolean() {
                return null;
            }
        };
    }
}
