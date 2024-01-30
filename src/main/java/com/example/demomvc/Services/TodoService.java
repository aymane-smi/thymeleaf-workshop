package com.example.demomvc.Services;

import java.util.List;

import com.example.demomvc.Entites.Todo;

public interface TodoService {
    public List<Todo> addTodo(Todo todo);
    public void deleteTodo(int id);
}
