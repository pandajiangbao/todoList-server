package com.thoughtworks.todolist.controller;

import com.thoughtworks.todolist.entity.Todo;
import com.thoughtworks.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
@CrossOrigin(value = "*")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(todoService.findAllTodos());
    }


    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        return ResponseEntity.ok(todoService.findTodoById(id));
    }
    @PostMapping
    public ResponseEntity createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo)?ResponseEntity.ok().build():ResponseEntity.badRequest().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable Integer id,@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.updateTodoById(id, todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        return todoService.deleteTodoById(id)?ResponseEntity.ok().build():ResponseEntity.badRequest().build();
    }
}
