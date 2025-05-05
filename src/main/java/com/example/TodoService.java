package com.example;

import jakarta.inject.Singleton;
import java.util.Optional;

@Singleton
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Iterable<Todo> list() {
        return todoRepository.findAll();
    }

    public Optional<Todo> get(Long id) {
        return todoRepository.findById(id);
    }

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public Optional<Todo> update(Long id, Todo updated) {
        return todoRepository.findById(id).map(todo -> {
            todo.setTitle(updated.getTitle());
            todo.setDescription(updated.getDescription());
            todo.setCompleted(updated.isCompleted());
            return todoRepository.update(todo);
        });
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}