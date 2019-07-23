package com.thoughtworks.todolist.service;

import com.thoughtworks.todolist.entity.Todo;
import com.thoughtworks.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> findTodoById(Integer id) {
        return todoRepository.findById(id);
    }

    public Boolean createTodo(Todo todo){
        try{
            todo.setIsSelected(false);
            todo.setIsEdited(false);
            todoRepository.saveAndFlush(todo);
            return true;
        }catch (Exception e){
            throw new RuntimeException("todo不能重复");
        }
    }
    public Todo updateTodoById(Integer id, Todo todo) {
        todo.setId(id);
        todo.setIsEdited(false);
        return todoRepository.saveAndFlush(todo);
    }

    public Boolean deleteTodoById(Integer id) {
        todoRepository.deleteById(id);
        return !todoRepository.findById(id).isPresent();
    }
}
