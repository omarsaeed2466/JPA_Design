package com.example.JPA_Design.Service;

import com.example.JPA_Design.Entity.Item;
import com.example.JPA_Design.Entity.Permissions;
import com.example.JPA_Design.Repository.ItemRepository;
import com.example.JPA_Design.Repository.PermissionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionsService {

    private final PermissionsRepository permissionsRepository;

    public PermissionsService(PermissionsRepository permissionsRepository) {
        this.permissionsRepository = permissionsRepository;
    }

    public Permissions savePermissions(Permissions permissions) {
        return permissionsRepository.save(permissions);
    }

    public Permissions getPermissionsById(Integer id) {
        return permissionsRepository.findById(id).orElse(null);
    }

    public List<Permissions> getAllPermissions() {
        return permissionsRepository.findAll();
    }

    public void deletePermissions(Permissions permissions) {
        permissionsRepository.delete(permissions);
    }
}
