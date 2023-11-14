package com.example.JPA_Design.Controller;

import com.example.JPA_Design.Entity.PermissionGroup;
import com.example.JPA_Design.Entity.Permissions;
import com.example.JPA_Design.Service.PermissionGroupService;
import com.example.JPA_Design.Service.PermissionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/PermissionGroup")
public class PermissionGroupController {


    private final PermissionGroupService permissionGroupService ;

    public PermissionGroupController(PermissionGroupService permissionGroupService) {
        this.permissionGroupService = permissionGroupService;
    }

    @GetMapping
    public List<PermissionGroup> getAllIPermissionGroup() {
        return permissionGroupService.getAllPermissionGroup();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionGroup> getPermissionGroupById(@PathVariable Integer id) {
        PermissionGroup permissionGroup = permissionGroupService.getPermissionGroupById(id);
        if (permissionGroup != null) {
            return ResponseEntity.ok(permissionGroup);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PermissionGroup> createPermissionGroup(@RequestBody PermissionGroup permissionGroup) {
        PermissionGroup createdPermissionGroup = permissionGroupService.savePermissionGroup(permissionGroup);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPermissionGroup);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionGroup> updatePermissionGroup(@PathVariable Integer id, @RequestBody PermissionGroup permissionGroup) {
        PermissionGroup existingPermissionGroup = permissionGroupService.getPermissionGroupById(id);
        if (existingPermissionGroup != null) {
            existingPermissionGroup.setGroupName(permissionGroup.getGroupName());
            existingPermissionGroup.setItems(permissionGroup.getItems());


            PermissionGroup updatedPermissionGroup = permissionGroupService.savePermissionGroup(existingPermissionGroup);
            return ResponseEntity.ok(updatedPermissionGroup);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermissionGroup(@PathVariable Integer id) {
        PermissionGroup permissionGroup = permissionGroupService.getPermissionGroupById(id);
        if (permissionGroup != null) {
            permissionGroupService.deletePermissionGroup(permissionGroup);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
