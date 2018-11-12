package com.kodewire.todoapp.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Todo entity with Lombok annotations
 */
@Table(name = "todos")
@Entity
@Data
@Builder
//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Todo {

    /**
     * ID
     */
    @Id
    private long id;

    /**
     * Title
     */
    @NotNull
    @Size(max = 100)
    private String title;

    /**
     * Description
     */
    @NotNull
    @Size(max = 1000)
    private String description;

    /**
     * Timestamp
     */
    @CreationTimestamp
    private LocalDateTime createdAt;

    /**
     * Event time
     */
    @NotNull
    private String eventTime;

}
