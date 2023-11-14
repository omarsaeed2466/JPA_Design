package com.example.JPA_Design.Repository;

import com.example.JPA_Design.Entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionsRepository extends JpaRepository<Permissions,Integer> {
}
