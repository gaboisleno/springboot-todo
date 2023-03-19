package com.project.todolist.collection;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.todolist.appUser.AppUser;
import com.project.todolist.task.Task;

import lombok.Data;

@Entity(name = "Collection")
@Table
@Data
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
    private String description;
    
    @OneToMany(mappedBy =  "collection")
    @JsonIgnoreProperties(value = "collection")
    private List<Task> tasks;

    @ManyToOne
    private AppUser user;
}
