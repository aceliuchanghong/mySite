package com.liu.site.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
public class FileController {
    private static final String UPLOAD_FOLDERS = System.getProperty("user.dir") + "/upload/";


    @PostMapping("/upload")
    public String upload(String whom, MultipartFile photo, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/upload/");
        saveFile(photo, path);
        System.out.println(path);
        return ", SUC";
    }


    public void saveFile(MultipartFile photo, String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) dir.mkdir();
        File file = new File(path + photo.getOriginalFilename());
        photo.transferTo(file);
    }
}
