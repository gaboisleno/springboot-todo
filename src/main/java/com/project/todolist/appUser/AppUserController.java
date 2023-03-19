package com.project.todolist.appUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class AppUserController {

    @Autowired
    private AppUserService userService;
    
    @GetMapping("/")
    public List<AppUserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public AppUserDTO findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping("/")
    public AppUserDTO save(@RequestBody AppUser user) {
        return userService.save(user);
    }
}
