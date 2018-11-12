package com.kodewire.todoapp.controllers;

import com.kodewire.todoapp.exceptions.TodoException;
import com.kodewire.todoapp.models.Todo;
import com.kodewire.todoapp.requests.AddTodoRequest;
import com.kodewire.todoapp.requests.EditTodoRequest;
import com.kodewire.todoapp.requests.RemoveTodosRequests;
import com.kodewire.todoapp.responses.ApiResponse;
import com.kodewire.todoapp.responses.ErrorReponse;
import com.kodewire.todoapp.responses.ListTodoResponse;
import com.kodewire.todoapp.responses.SuccessResponse;
import com.kodewire.todoapp.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/todos")
public class TodoController {

    /**
     * Todo service
     */
    @Autowired
    TodoService todoService;

    /**
     * Create a new Todo
     *
     * @param addTodoRequest Request to add todo
     * @return Returns api response either success or error
     */
    @PostMapping("/create")
    public ApiResponse create(@Valid @RequestBody AddTodoRequest addTodoRequest) {

        Todo todo = Todo.builder().title(addTodoRequest.getTitle())
                .description(addTodoRequest.getDescription())
                .eventTime(addTodoRequest.getEventTime())
                .eventTime(addTodoRequest.getEventTime())
                .build();

        try {
            todoService.create(todo);
        } catch (Exception e) {
            return ErrorReponse.builder()
                    .message("A runtime error occured. Please try later.")
                    .status("error")
                    .build();
        }


        return SuccessResponse.builder()
                .status("success")
                .message("Todo created successfully.")
                .build();


    }

    /**
     * List all todos
     *
     * @return list of todos
     */
    @GetMapping
    public ApiResponse list() {
        List<Todo> todoList = todoService.getAll();
        return ListTodoResponse.builder()
                .status("success")
                .todos(todoList)
                .build();
    }

    /**
     * Delets an individual todo
     *
     * @param id path id to delete todo
     * @return Sucess or Error ApiResponse
     */
    @PostMapping("/delete/{id}")
    public ApiResponse deleteTodo(@PathVariable("id") long id) {
        Todo todo = todoService.find(id);
        if (todo == null) {
            return ErrorReponse.builder().status("error")
                    .message("Todo not found")
                    .build();
        } else {
            todoService.remove(todo);
            return SuccessResponse.builder().status("success")
                    .message("Todo removed")
                    .build();
        }
    }

    /**
     * Deletes multiple todos
     *
     * @param removeTodosRequests: list of todos to remove
     * @return Success or error api response
     */
    @PostMapping("/delete")
    public ApiResponse deleteMultipleTodos(@Valid @RequestBody RemoveTodosRequests removeTodosRequests) {
        try {
            List<Long> todoIds = removeTodosRequests.getTodoIds();

            for (long id : todoIds) {
                Todo todo = todoService.find(id);
                if (todo != null) {
                    todoService.remove(todo);
                }
            }
        } catch (Exception e) {
            return ErrorReponse.builder().status("error").message("A system error occured.").build();
        }

        return SuccessResponse.builder().status("success")
                .message("Todos removed")
                .build();

    }

    /**
     * Update a todo
     *
     * @param editTodoRequest EditTodoRequest object
     * @return Api response
     */
    @PostMapping("/edit")
    public ApiResponse edit(@Valid @RequestBody EditTodoRequest editTodoRequest) {
        Todo todo = todoService.find(editTodoRequest.getId());
        if (todo == null) {
            return ErrorReponse.builder().status("error")
                    .message("Todo not found")
                    .build();
        } else {
            todo.setTitle(editTodoRequest.getTitle());
            todo.setDescription(editTodoRequest.getDesc());
            todo.setEventTime(editTodoRequest.getEventTime());

            todoService.update(todo);

            return SuccessResponse.builder().status("success")
                    .message("Todo saved")
                    .build();
        }
    }


}
