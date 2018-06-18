package com.greenfoxacademy.connectionwithmysqlsecond.services;

import com.greenfoxacademy.connectionwithmysqlsecond.models.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public interface TodoService {

    public Optional<Todo> getTodoById(long id);

    public List<Todo> getAllTodo();

    public List<Todo> getAllActiveTodo(boolean active);
}