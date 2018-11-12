package com.kodewire.todoapp.repositories;

import com.kodewire.todoapp.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Todo repo
 */
@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findAll();
}
