package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.model.Rentals;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;
/**
* Control file saving
*
* */
@Service
public class FileSystemStorageService implements IFileSystemStorageService {
    private final Path rootLocation;
    @Autowired
    public FileSystemStorageService() {
        this.rootLocation = Paths.get(Paths.get("").toAbsolutePath().toString() +"/src/test/java/com/openclassroom/ApiChatop/target/");
    }
    @Override
    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {}
    }

    //Save a file with a specific name in a repository
    @Override
    public String store(Rentals rentals,MultipartFile file) {

        String filename = StringUtils.cleanPath(rentals.getName()+"-"+rentals.getSurface()+"-"+rentals.getPrice()+"-"+file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new IOException();
            }
            if (filename.contains("..")) {
                throw new IOException();
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.rootLocation.resolve(filename).toString();
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1).filter(path -> !path.equals(this.rootLocation)).map(this.rootLocation::relativize);
        } catch (IOException e) {	return null; }
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}