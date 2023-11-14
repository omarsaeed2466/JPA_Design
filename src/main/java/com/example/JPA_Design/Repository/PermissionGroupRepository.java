package com.example.JPA_Design.Repository;

import com.example.JPA_Design.Entity.PermissionGroup;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionGroupRepository extends JpaRepository<PermissionGroup,Integer> {
}
