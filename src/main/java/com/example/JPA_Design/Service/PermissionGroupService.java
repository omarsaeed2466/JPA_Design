package com.example.JPA_Design.Service;

import com.example.JPA_Design.Entity.PermissionGroup;
import com.example.JPA_Design.Entity.Permissions;
import com.example.JPA_Design.Repository.PermissionGroupRepository;
import com.example.JPA_Design.Repository.PermissionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionGroupService {
    private final PermissionGroupRepository permissionGroupRepository ;

    public PermissionGroupService(PermissionGroupRepository permissionGroupRepository) {
        this.permissionGroupRepository = permissionGroupRepository;
    }

    public PermissionGroup savePermissionGroup(PermissionGroup permissionGroup) {
        return permissionGroupRepository.save(permissionGroup);
    }

    public PermissionGroup getPermissionGroupById(Integer id) {
        return permissionGroupRepository.findById(id).orElse(null);
    }

    public List<PermissionGroup> getAllPermissionGroup() {
        return permissionGroupRepository.findAll();
    }

    public void deletePermissionGroup(PermissionGroup permissionGroup) {
        permissionGroupRepository.delete(permissionGroup);
    }
}
