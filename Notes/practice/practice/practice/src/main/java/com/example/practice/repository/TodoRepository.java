package com.example.practice.repository;

import com.example.practice.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepository {

    private final List<Todo> todos = new ArrayList<>();

    public List<Todo> findAll(){return todos;}

    public void save(Todo todo){
        todos.add(todo);
    }

    public Todo findById(String  id){
        for (Todo todo:todos){
            if (todo.getId().equals(id)){
                return todo;
            }
        }
        return null;
    }

}
