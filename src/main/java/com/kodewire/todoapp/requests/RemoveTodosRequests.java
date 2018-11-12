package com.kodewire.todoapp.requests;

import lombok.Data;

import javax.persistence.Embedded;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class RemoveTodosRequests {

    @NotNull
    List<Long> todoIds;

}
