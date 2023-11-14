package com.example.JPA_Design.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "Item_type")
    private ItemType type;
    @Column(name = "Item_name")
    private String name;

    @ManyToOne(optional = false)
    private PermissionGroup permissionGroup;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
