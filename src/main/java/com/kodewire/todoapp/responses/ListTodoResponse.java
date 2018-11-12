package com.kodewire.todoapp.responses;

import com.kodewire.todoapp.models.Todo;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * List todo response
 */
@Builder
public class ListTodoResponse implements ApiResponse {

    /**
     * Status
     */
    public String status;

    /**
     * List of todos
     */
    public List<Todo> todos = new ArrayList<>();

}
