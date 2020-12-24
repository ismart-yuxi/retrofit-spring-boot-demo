package com.example.retrofit.controller;

import com.example.retrofit.domain.User;
import com.example.retrofit.remote.HttpApi;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.lang.Math.random;

@RestController
@Slf4j
@RequestMapping(value = "/retrofit/")
public class RetrofitController {

    @Autowired
    private HttpApi userService;

    @GetMapping("/user")
    public String  userPerformed() {
        User user = new User();
        user.setUsername(UUID.randomUUID().toString());
        user.setPassword(UUID.randomUUID().toString());
        user.setAge((int)(random()*100)+1);
        userService.addUser(user);
        userService.updateUser(user);
        List<User> users = userService.users();
        System.out.println(users);
        userService.user(users.get(0).getId());
        userService.deleteUser(users.get(0).getId());
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
