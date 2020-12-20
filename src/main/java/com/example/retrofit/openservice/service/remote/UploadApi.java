package com.example.retrofit.openservice.service.remote;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

@RetrofitClient(baseUrl = "${example.upload-service.base-url}")
public interface UploadApi {


    /**
     * 演示上传
     * @param file 要上传的文件
     * @return
     */
    @POST("upload")
    @Multipart
    String upload(@Part MultipartBody.Part file);

}
