package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.model.Rentals;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface IFileSystemStorageService {
    void init();
    String store(Rentals rentals, MultipartFile file);
    Stream<Path> loadAll();
    Path load(String filename);
    void deleteAll();
}
