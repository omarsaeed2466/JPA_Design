package com.example.JPA_Design.Repository;

import com.example.JPA_Design.Entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files,Integer> {
}
