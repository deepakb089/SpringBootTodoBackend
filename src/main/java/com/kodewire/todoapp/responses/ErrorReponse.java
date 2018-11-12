package com.kodewire.todoapp.responses;

import lombok.Builder;

/**
 * Error response
 */
@Builder
public class ErrorReponse implements ApiResponse {
    /**
     * Status
     */
    public String status;

    /**
     * Message
     */
    public String message;
}
