package com.kodewire.todoapp.requests;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * HTTP JSON request to edit todo
 */
@Data
public class EditTodoRequest {

    /**
     * Todo's id
     */
    @NotNull
    private long id;

    /**
     * Todo's title
     */
    @NotNull
    @Size(max = 100)
    private String title;

    /**
     * Description
     */
    @NotNull
    @Size(max = 1000)
    private String desc;


    /**
     * Todo event's time
     */
    @NotNull
    private String eventTime;

}
