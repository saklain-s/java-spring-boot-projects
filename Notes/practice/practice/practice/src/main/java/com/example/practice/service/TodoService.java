package com.example.practice.service;

import com.example.practice.model.Todo;
import com.example.practice.repository.TodoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.function.Supplier;
@Service
public class TodoService {

    private final TodoRepository repo;
    private final Supplier<String> idGenerator;

    public TodoService(TodoRepository repo, Supplier<String> idGenerator){
        this.repo = repo;
        this.idGenerator = idGenerator;
    }

    public List<Todo> getTodos(){
        return repo.findAll();
    }

    public Todo addTodo(String title, boolean completed){
        String id = idGenerator.get();
        Todo todo = new Todo(id,title,completed);
        repo.save(todo);
        return todo;
    }

    public Todo updateComplete(String id){
        Todo todo = repo.findById(id);
        if (todo == null){
            throw new RuntimeException("Todo Not Found!");
        }
        todo.setCompleted(true);
        return todo;
    }
}