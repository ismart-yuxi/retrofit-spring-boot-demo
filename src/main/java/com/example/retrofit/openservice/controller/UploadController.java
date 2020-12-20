package com.example.retrofit.openservice.controller;

import com.example.retrofit.openservice.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * @author wangyuxi
 */
@RestController
@RequestMapping("/micro-service")
public class UploadController {

    @Autowired
    private UploadService uploadService;


    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        uploadService.uploadFile( file);
        return "success";
    }
}
