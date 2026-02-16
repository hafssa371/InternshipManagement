package com.example.intership.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class FileStorageService {
    @Value("${file.upload-dir}")
    private String uploadDir;

    public String storeFile(MultipartFile file) throws IOException {

        if (!file.getContentType().equals("application/pdf")) {
            throw new RuntimeException("Only PDF files allowed");
        }

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);

        Files.copy(file.getInputStream(), filePath,
                StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

    public Resource loadFile(String fileName) throws IOException {

        Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();

        if (!Files.exists(filePath)) {
            throw new RuntimeException("File not found");
        }

        return new UrlResource(filePath.toUri());
    }

}
