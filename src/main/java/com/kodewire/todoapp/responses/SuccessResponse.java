package com.kodewire.todoapp.responses;

import lombok.Builder;

/**
 * Generic success reponse
 */
@Builder
public class SuccessResponse implements ApiResponse {
    public String status;
    public String message;
}
