package com.project.todolist.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);
    
    @Autowired
    private TaskService taskService;
    
    @GetMapping("/")
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @PostMapping("/")
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }
}
