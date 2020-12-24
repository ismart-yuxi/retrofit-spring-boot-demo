package com.example.openservice.controller;

import com.example.openservice.domain.User;
import com.example.openservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/openservice/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public String  addUser(@RequestBody User user) {
        userService.addUser(user);
        return "add success";
    }

    @PutMapping("/user")
    public String  updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return "update success";
    }

    @DeleteMapping("/user/{id}")
    public String  deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "delete success";
    }

    @GetMapping("/user/{id}")
    public User  user(@PathVariable Long id) {
        return userService.user(id);
    }

    @GetMapping("/user")
    public List<User> users() {
        return (List<User>) userService.AllUser();
    }


    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        String filePath = "C:/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            log.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return "上传失败！";
    }
}
