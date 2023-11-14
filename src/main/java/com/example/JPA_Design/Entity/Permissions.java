package com.example.JPA_Design.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Permissions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "userEmail")
    private String userEmail;
    @Column(name = "permissionLevel")
    private PermissionLevel permissionLevel;

    @ManyToOne(optional = false)
    private PermissionGroup permissionGroup;


    @Override
    public String toString() {
        return "Permissions{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", permissionLevel='" + permissionLevel + '\'' +
                '}';
    }
}
