package com.example.retrofit.controller;

import com.example.retrofit.domain.User;
import com.example.retrofit.remote.HttpApi;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Objects;
import java.util.UUID;

import static java.lang.System.out;

@RestController
@Slf4j
@RequestMapping(value = "/retrofit/")
public class RetrofitController {

    @Autowired
    private HttpApi httpApi;

    @GetMapping("/user")
    public String userPerformed() throws IOException {
        User user = new User();
        user.setAge(23);
        user.setPassword("123456");
        user.setUsername("xxzx");

        httpApi.addUser(user).execute();

        httpApi.users().execute().body().forEach(x -> {
            out.println(x.toString());
        });

        user.setId(10000L);
        user.setUsername("KKKKKKKKKKKKKKKKKK");
        user.setPassword("asdfasdfsadfsdf");
        user.setAge(60);
        out.println(new String(Objects.requireNonNull(httpApi.updateUser(user).execute().body()).bytes()));

        Objects.requireNonNull(httpApi.users().execute().body()).forEach(x -> {
            out.println(x.toString());
        });

        out.println(httpApi.user(10000L));

        out.println(new String(Objects.requireNonNull(httpApi.deleteUser(1608823107168L).execute().body()).bytes()));


        // 二进制流
        InputStream is =  httpApi.download().body().byteStream();

        saveFile(is);

        return "success";
    }

    private void saveFile(InputStream is) throws IOException {
        // 具体如何处理二进制流，由业务自行控制。这里以写入文件为例
        File tempDirectory = new File("temp");
        if (!tempDirectory.exists()) {
            tempDirectory.mkdir();
        }
        File file = new File(tempDirectory, UUID.randomUUID().toString());
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        byte[] b = new byte[1024];
        int length;
        while ((length = is.read(b)) > 0) {
            fos.write(b, 0, length);
        }
        is.close();
        fos.close();
    }

    @GetMapping("/dynamicUrlPerformed")
    public boolean dynamicUrlPerformed() {
        boolean dynamicUrl1 = httpApi.dynamicUrl("http://localhost:9000/openservice/dynamic1/url1/", "url1").body().get("dynamicUrl1").equals("/dynamic1/url1/url1");
        boolean dynamicUrl2 = httpApi.dynamicUrl("http://localhost:9000/openservice/dynamic2/url2/", "url2").body().get("dynamicUrl2").equals("/dynamic2/url2/url2");
        return dynamicUrl1 && dynamicUrl2;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        // 对文件名使用URLEncoder进行编码
        String fileName = URLEncoder.encode(Objects.requireNonNull(file.getOriginalFilename()), "utf-8");
        okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(MediaType.parse("multipart/form-data"), file.getBytes());
        httpApi.upload(MultipartBody.Part.createFormData("file", fileName, requestBody)).execute();
        return "success";
    }

}
