package com.example.demomvc.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demomvc.Entites.Todo;

import lombok.Data;

@Service
@Data
public class TodoServiceImpl implements TodoService{
    private int idCounter = 0;
    private List<Todo> todos = new ArrayList<>();

    @Override
    public List<Todo> addTodo(Todo todo) {
        todo.setId(++idCounter);
        todos.add(todo);
        return todos;
    }

    @Override
    public void deleteTodo(int id) {
        for(int i=0;i<todos.size();i++)
            if(todos.get(i).getId() == id)
                todos.remove(i);
    }

}
