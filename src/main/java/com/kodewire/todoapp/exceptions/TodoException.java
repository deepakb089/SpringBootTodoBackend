package com.kodewire.todoapp.exceptions;

import lombok.Builder;

/**
 * Generic Todo Exception
 */
@Builder
public class TodoException extends Exception {
    public String message;
}
