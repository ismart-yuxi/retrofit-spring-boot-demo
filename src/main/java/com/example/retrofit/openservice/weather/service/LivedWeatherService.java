package com.example.retrofit.openservice.weather.service;

import com.example.retrofit.openservice.weather.domain.responseEntity.Response;
import com.example.retrofit.openservice.weather.service.remote.HttpApi;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;

/**
 * @author wangyuxi
 * @date 2020/08/24
 **/
@Service
public class LivedWeatherService {

    @Autowired
    private HttpApi httpApi;

    public Response livedWeather(Map<String, String> requestParamMap) {
        return httpApi.api(requestParamMap);
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = URLEncoder.encode(Objects.requireNonNull(file.getOriginalFilename()), "utf-8");
        okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(MediaType.parse("multipart/form-data"), file.getBytes());
        return httpApi.upload(MultipartBody.Part.createFormData("file", fileName, requestBody));
    }

}
