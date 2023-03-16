package com.project.todolist.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    public TaskController(){
        
    }

    @GetMapping("/ping")
    public String ping(){
        return "200";
    }

    @GetMapping("/")
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @PostMapping("/")
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }
}
