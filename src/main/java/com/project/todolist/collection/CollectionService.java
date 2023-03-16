package com.project.todolist.collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionService {
    
    @Autowired
    private CollectionRepository collectionRepository;

    public List<Collection> getAll() {
        return collectionRepository.findAll();
    }

    public Collection save(Collection collection) {
        return collectionRepository.save(collection);
    }
}
