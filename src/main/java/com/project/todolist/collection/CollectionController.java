package com.project.todolist.collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @GetMapping("/")
    public List<Collection> findAll() {
        return collectionService.findAll();
    }

    @GetMapping("/{id}")
    public Collection findById(@PathVariable Long id) {
        return collectionService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        collectionService.deleteById(id);
    }

    @PostMapping("/")
    public Collection save(@RequestBody Collection collection) {
        return collectionService.save(collection);
    }
    
}
