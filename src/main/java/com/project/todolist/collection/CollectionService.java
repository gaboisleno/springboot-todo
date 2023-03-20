package com.project.todolist.collection;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CollectionService {
    
    @Autowired
    private CollectionRepository collectionRepository;

    public List<Collection> findAll() {
        return collectionRepository.findAll();
    }

    public Collection findById(Long id) {
        return collectionRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found"));
    }

    public Collection save(Collection collection) {
        return collectionRepository.save(collection);
    }

    public void deleteById(Long id) {
        Optional<Collection> collectionToDelete = collectionRepository.findById(id);
        if (collectionToDelete.isPresent() && collectionToDelete.get().getTasks().isEmpty()) {
            collectionRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Collection not found or not empty");
        }
    }
}
