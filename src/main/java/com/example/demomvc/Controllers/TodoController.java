package com.example.demomvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demomvc.Entites.Todo;
import com.example.demomvc.Services.TodoServiceImpl;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/")
public class TodoController {
    private TodoServiceImpl todoService;

    public TodoController(TodoServiceImpl todoService){
        this.todoService = todoService;
    }
    @GetMapping
    public String main(Model model){
        model.addAttribute("todos", todoService.getTodos());
        return "main";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("todo", new Todo());
        return "add";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Todo todo, BindingResult result){
        if(result.hasErrors()){
            System.out.println(result.getFieldError("description"));
            return "add";
        }else{
            todoService.addTodo(todo);
            return "redirect:/?type=add";
        }
        
    }
    @PostMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        todoService.deleteTodo(id);
        return "redirect:/?type=delete";
    }
    
}
