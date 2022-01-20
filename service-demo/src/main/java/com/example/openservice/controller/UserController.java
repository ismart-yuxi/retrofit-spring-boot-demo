package com.example.openservice.controller;

import com.example.openservice.domain.User;
import com.example.openservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/openservice/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "add success";
    }

    @PutMapping("/user")
    public String updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return "update success";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "delete success";
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable Long id) {
        return userService.user(id);
    }

    @GetMapping("/user")
    public List<User> users() {
        return (List<User>) userService.AllUser();
    }


    @GetMapping("/download")
    public ResponseEntity<byte[]> download() throws IOException {
        String dfileName = new String("file_download".getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", dfileName);
        Path filePath = ResourceUtils.getFile("classpath:application.yaml").toPath();
        return new ResponseEntity<>(Files.readAllBytes(filePath), headers, HttpStatus.CREATED);
    }


    @PostMapping("/upload")
    public String upload(@RequestParam("files") MultipartFile[] files) {
        Arrays.stream(files).forEach(file -> {
            if (!file.isEmpty()) {
                try {
                    String fileName = URLDecoder.decode(Objects.requireNonNull(file.getOriginalFilename()), StandardCharsets.UTF_8.name());
                    String filePath = "D:/";
                    File dest = new File(filePath + fileName);
                    file.transferTo(dest);
                    log.info("上传成功");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return "上传成功";
    }

    @GetMapping("/returnValueString")
    public String returnValueString() {
        return System.currentTimeMillis() + "";
    }


    @GetMapping("/returnValueBoolean")
    public Boolean returnValueBoolean() {
        return Boolean.TRUE;
    }
}
