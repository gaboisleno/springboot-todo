package com.project.todolist.task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.todolist.collection.Collection;

import lombok.Data;

@Entity(name = "Task")
@Table
@Data
public class Task {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
    private String description;

    @Column(name = "done")
    private Boolean done;

    @ManyToOne
    @JsonIgnoreProperties(value = "tasks", allowSetters = true)
    private Collection collection;
}
