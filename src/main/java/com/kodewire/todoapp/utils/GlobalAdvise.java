package com.kodewire.todoapp.utils;

import com.kodewire.todoapp.responses.ApiResponse;
import com.kodewire.todoapp.responses.ErrorReponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalAdvise {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ApiResponse methodArgumentsNotValid(MethodArgumentNotValidException exp) {
        return ErrorReponse.builder().status("error")
                .message("Illegal aruments")
                .build();

    }

}
