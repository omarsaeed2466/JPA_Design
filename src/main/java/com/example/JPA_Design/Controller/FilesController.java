package com.example.JPA_Design.Controller;

import com.example.JPA_Design.Entity.Files;

import com.example.JPA_Design.Entity.Item;
import com.example.JPA_Design.Service.FilesService;
import com.example.JPA_Design.Service.ItemService;
import jdk.jfr.ContentType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FilesController {

    private final FilesService filesService ;
    private final ItemService itemService ;

    public FilesController(FilesService filesService, ItemService itemService) {
        this.filesService = filesService;
        this.itemService = itemService;
    }


    @GetMapping
    public List<Files> getAllIFiles() {
        return filesService.getAllFiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Files> getFilesById(@PathVariable Integer id) {
        Files files = filesService.getFilesById(id);
        if (files != null) {
            return ResponseEntity.ok(files);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/files",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Transactional
    public String uploadFile(@RequestPart("binary") MultipartFile file,
                             @RequestPart("id") String itemId) {
        if (!file.isEmpty()) {
            try {
                byte[] fileData = file.getBytes();

                // Create a new Files instance
                Files newFile = new Files();
                newFile.setBinary(fileData);

                // Retrieve and set the associated Item
                Item associatedItem = itemService.getItemById(Integer.valueOf(itemId));
                newFile.setItem(associatedItem);

                // Save the Files entity to the database
                filesService.saveFiles(newFile);

                return "File uploaded successfully!";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "File upload failed!";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Files> updateFiles(@PathVariable Integer id, @RequestBody Files files) {
        Files existingFile = filesService.getFilesById(id);
        if (existingFile != null) {
            existingFile.setBinary(files.getBinary());
            existingFile.setItem(files.getItem());

            Files updatedFile = filesService.saveFiles(existingFile);
            return ResponseEntity.ok(updatedFile);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiles(@PathVariable Integer id) {
        Files files = filesService.getFilesById(id);
        if (files != null) {
            filesService.deleteFiles(files);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
