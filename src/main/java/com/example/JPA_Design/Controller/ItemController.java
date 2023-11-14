package com.example.JPA_Design.Controller;

import com.example.JPA_Design.Entity.Item;
import com.example.JPA_Design.Service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Integer id) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item createdItem = itemService.saveItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Integer id, @RequestBody Item item) {
        Item existingItem = itemService.getItemById(id);
        if (existingItem != null) {
            existingItem.setType(item.getType());
            existingItem.setName(item.getName());
            existingItem.setPermissionGroup(item.getPermissionGroup());
            Item updatedItem = itemService.saveItem(existingItem);
            return ResponseEntity.ok(updatedItem);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Integer id) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            itemService.deleteItem(item);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}