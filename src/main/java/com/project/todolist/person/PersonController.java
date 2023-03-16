package com.project.todolist.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class PersonController {

    @Autowired
    private PersonService userService;
    

    @GetMapping("/")
    public List<Person> getAll() {
        return userService.getAll();
    }

    @PostMapping("/")
    public Person save(@RequestBody Person user) {
        return userService.save(user);
    }
}
