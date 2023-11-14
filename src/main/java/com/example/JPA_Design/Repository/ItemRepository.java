package com.example.JPA_Design.Repository;

import com.example.JPA_Design.Entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
