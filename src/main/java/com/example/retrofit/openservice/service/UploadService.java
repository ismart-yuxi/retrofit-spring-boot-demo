package com.example.retrofit.openservice.service;

import com.example.retrofit.openservice.service.remote.UploadApi;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Objects;

@Service
public class UploadService {

    @Autowired
    private UploadApi uploadApi;

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = URLEncoder.encode(Objects.requireNonNull(file.getOriginalFilename()), "utf-8");
        okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(MediaType.parse("multipart/form-data"), file.getBytes());
        return uploadApi.upload(MultipartBody.Part.createFormData("file", fileName, requestBody));
    }
}
