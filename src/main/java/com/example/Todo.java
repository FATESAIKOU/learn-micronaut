package com.example;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.GeneratedValue.Type;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable // 新增這行，讓 Todo 支援序列化/反序列化
@MappedEntity("todos")
public class Todo {
    @Id
    @GeneratedValue(Type.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean completed = false;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}