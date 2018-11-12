package com.kodewire.todoapp.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * HTTP JSON Request to add a new todo
 */
@Data
public class AddTodoRequest {

    /**
     * Title
     */
    @NotNull
    @Size(max = 100, min = 5)
    private String title;

    /**
     * Descrption
     */
    @NotNull
    @Size(max = 1000, min = 5)
    private String description;

    /**
     * Event time
     */
    @NotNull
    private String eventTime;

}
