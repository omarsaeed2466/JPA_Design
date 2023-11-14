package com.example.JPA_Design.Service;

import com.example.JPA_Design.Entity.Files;
import com.example.JPA_Design.Entity.Item;
import com.example.JPA_Design.Repository.FilesRepository;
import com.example.JPA_Design.Repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FilesService {
    private final FilesRepository filesRepository;

    public FilesService(FilesRepository filesRepository) {
        this.filesRepository = filesRepository;
    }

    public Files saveFiles(Files files) {
        return filesRepository.save(files);
    }

    public Files getFilesById(Integer id) {
        return filesRepository.findById(id).orElse(null);
    }

    public List<Files> getAllFiles() {
        return filesRepository.findAll();
    }

    public void deleteFiles(Files files) {
        filesRepository.delete(files);
    }
}
