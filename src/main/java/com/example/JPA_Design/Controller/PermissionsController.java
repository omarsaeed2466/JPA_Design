package com.example.JPA_Design.Controller;


import com.example.JPA_Design.Entity.Permissions;
import com.example.JPA_Design.Service.PermissionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Permissions")
public class PermissionsController {

    private final PermissionsService permissionsService ;

    public PermissionsController(PermissionsService permissionsService) {
        this.permissionsService = permissionsService;
    }


    @GetMapping
    public List<Permissions> getAllIPermissions() {
        return permissionsService.getAllPermissions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permissions> getPermissionsById(@PathVariable Integer id) {
        Permissions permissions = permissionsService.getPermissionsById(id);
        if (permissions != null) {
            return ResponseEntity.ok(permissions);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Permissions> createPermissions(@RequestBody Permissions permissions) {
        Permissions createdPermissions = permissionsService.savePermissions(permissions);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPermissions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permissions> updatePermissions(@PathVariable Integer id, @RequestBody Permissions permissions) {
        Permissions existingPermissions = permissionsService.getPermissionsById(id);
        if (existingPermissions != null) {
            existingPermissions.setPermissionLevel(permissions.getPermissionLevel());
            existingPermissions.setUserEmail(permissions.getUserEmail());
            existingPermissions.setPermissionGroup(permissions.getPermissionGroup());

            Permissions updatedPermissions = permissionsService.savePermissions(existingPermissions);
            return ResponseEntity.ok(updatedPermissions);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermissions(@PathVariable Integer id) {
        Permissions permissions = permissionsService.getPermissionsById(id);
        if (permissions != null) {
            permissionsService.deletePermissions(permissions);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
