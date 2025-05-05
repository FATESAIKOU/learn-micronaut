package com.example;

import io.micronaut.http.annotation.*;
import io.micronaut.http.HttpResponse;
import java.util.Optional;

@Controller("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Get
    public Iterable<Todo> list() {
        return todoService.list();
    }

    @Get("/{id}")
    public HttpResponse<Todo> get(Long id) {
        return todoService.get(id)
                .map(HttpResponse::ok)
                .orElse(HttpResponse.notFound());
    }

    @Post
    public HttpResponse<Todo> create(@Body Todo todo) {
        return HttpResponse.created(todoService.create(todo));
    }

    @Put("/{id}")
    public HttpResponse<Todo> update(Long id, @Body Todo todo) {
        return todoService.update(id, todo)
                .map(HttpResponse::ok)
                .orElse(HttpResponse.notFound());
    }

    @Delete("/{id}")
    public HttpResponse<?> delete(Long id) {
        todoService.delete(id);
        return HttpResponse.noContent();
    }
}
