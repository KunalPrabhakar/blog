package com.blogapis.blogappforapis.service.impl;

import com.blogapis.blogappforapis.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
@Service
public class FIleServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        String name=file.getOriginalFilename();
        String randomID= UUID.randomUUID().toString();
String fileName=randomID.concat(name.substring(name.lastIndexOf(".")));
String filePath=path+ File.separator+fileName;
File f=new File(path);
if(!f.exists()){
f.mkdir();
}
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath=path+File.separator+fileName;
        InputStream is=new FileInputStream(fullPath);
        // Return the original file name
        return is;
    }
}
