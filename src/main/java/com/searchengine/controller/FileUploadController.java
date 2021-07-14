package com.searchengine.controller;

import com.searchengine.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    @Autowired
    FileService fileUploadService;

    @PostMapping
    public void uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        fileUploadService.uploadFile(file);
    }

}
