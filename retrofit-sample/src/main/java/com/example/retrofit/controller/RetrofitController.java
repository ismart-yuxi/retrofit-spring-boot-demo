package com.example.retrofit.controller;

import com.example.retrofit.remote.HttpApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Objects;

import static java.lang.System.out;

@RestController
@Slf4j
@RequestMapping(value = "/retrofit/")
public class RetrofitController {

    @Autowired
    private HttpApi userService;

    @GetMapping("/user")
    public String  userPerformed() throws JsonProcessingException {
        String json = "{\n" +
            "  \"username\" : \"998b436f-7347-4e20-b9a8-16a580128d68\",\n" +
            "  \"age\" : 14,\n" +
            "  \"password\" : \"fe1ae6a5-7675-43bb-91ef-68e719c033e4\"\n" +
            "}";

        userService.addUser(json);

//        UseruserService.user(user.getId());
//
//        userService.updateUser(jsonString);


        String users = userService.users();
        out.println(users);
//        userService.deleteUser(users.get(0).getId());
        return "v success";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        // 对文件名使用URLEncoder进行编码
        String fileName = URLEncoder.encode(Objects.requireNonNull(file.getOriginalFilename()), "utf-8");
        okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(MediaType.parse("multipart/form-data"),file.getBytes());
        userService.upload(MultipartBody.Part.createFormData("file", fileName, requestBody));
        return "success";
    }

}
