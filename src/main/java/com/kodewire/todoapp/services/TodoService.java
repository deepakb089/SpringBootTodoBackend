package com.kodewire.todoapp.services;

import com.kodewire.todoapp.exceptions.TodoException;
import com.kodewire.todoapp.models.Todo;
import com.kodewire.todoapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import java.util.List;
import java.util.Optional;

/**
 * Todo service
 */
@Service
public class TodoService {

    /**
     * Todo repo
     */
    @Autowired
    TodoRepository todoRepository;


    /**
     * Create a new todo
     * @param t : type Todo to save
     *
     */
    public void create(Todo t) {
        todoRepository.save(t);
    }

    public void delete(long id) {

    }

    /**
     * get all todos
     * @return the list of todos
     */
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    /**
     * Find a single todo
     * @param id todo's id to find
     * @return found todo or null
     */
    public Todo find(long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            return todoOptional.get();
        } else {
            return null;
        }
    }

    /**
     * Remove a todo
     * @param todo todo object to delete
     */
    public void remove(Todo todo) {
        todoRepository.delete(todo);
    }

    /**
     * Update a todo
     * @param todo todo object to update
     */
    public void update(Todo todo) {
        todoRepository.save(todo);
    }


}
