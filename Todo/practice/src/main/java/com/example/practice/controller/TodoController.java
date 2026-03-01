package com.example.practice.controller;


import com.example.practice.model.Todo;
import com.example.practice.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service){
        this.service = service;
    }

    @GetMapping
    public List<Todo> getTodos(){
        return service.getTodos();
    }

    @PostMapping
    public Todo add(@RequestBody Map<String, String> body){
        return service.addTodo(body.get("title"),false);
    }

    @PutMapping("/{id}/complete")
    public Todo updateTodo(@PathVariable String id){
        return service.updateComplete(id);
    }

    @DeleteMapping("/{id}")
    public Todo deleteTodo(@PathVariable String id){
        return service.delete(id);
    }

}
