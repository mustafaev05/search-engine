package com.searchengine.controller;

import com.searchengine.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Set;

@RestController
public class FileUploadController {

    @Autowired
    FileService fileUploadService;

    @PostMapping("/uploadFile")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        fileUploadService.uploadFile(file);
    }

    @GetMapping("/search")
    public Set<String> searchWord(@RequestParam(name = "word") String word) {
        return fileUploadService.searchWord(word);
    }

    @GetMapping("/test")
    public Map<String, Set<String>> getMap() {
        return fileUploadService.getMapOfFiles();
    }

}
