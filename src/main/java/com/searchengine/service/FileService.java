package com.searchengine.service;

import com.searchengine.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;
import java.util.Set;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

    public void uploadFile(MultipartFile multipartFile) throws Exception {
        File file = new File("C:\\Users\\bigshoma05\\Desktop\\search-engine1\\src\\main\\resources\\files\\"
                + multipartFile.getOriginalFilename());

        multipartFile.transferTo(file);
        fileRepository.addMapOfFile(file);
    }

    public Set<String> searchWord(String word) {
        return fileRepository.searchWord(word);
    }

    public Map<String, Set<String>> getMapOfFiles() {
        return fileRepository.getMapOfFiles();
    }

}
