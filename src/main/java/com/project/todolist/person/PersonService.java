package com.project.todolist.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository userRepository;

    public List<Person> getAll() {
        return userRepository.findAll();
    }

    public Person save(Person user) {
        return userRepository.save(user);
    }

}
