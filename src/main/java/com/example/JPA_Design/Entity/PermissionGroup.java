package com.example.JPA_Design.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class PermissionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "groupName")
    private String groupName;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "PermissionGroup_items",
            joinColumns = @JoinColumn(name = "items_Id"),
            inverseJoinColumns = @JoinColumn(name = "PermissionGroup_Id"))
    private List<Item> items;

    @Override
    public String toString() {
        return "PermissionGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
