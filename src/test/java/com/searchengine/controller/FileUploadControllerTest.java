package com.searchengine.controller;

import com.searchengine.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FileUploadControllerTest {

    @Autowired
    private FileService fileService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenFileUploaded_thenVerifyStatus() throws Exception {

        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello, World!".getBytes()
        );

        mockMvc.perform(multipart("/uploadFile").file(file))
                .andExpect(status().isOk());
    }

    @Test
    public void isSearchingWorking() throws Exception {

        MockMultipartFile file = new MockMultipartFile("file",
                "hello1.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello, World!".getBytes());
        fileService.uploadFile(file);

        mockMvc.perform(get(("/search?word=hello")))
                .andExpect(status().isOk());
    }


}
