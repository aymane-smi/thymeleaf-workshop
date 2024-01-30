package com.example.demomvc.Entites;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Todo {
    private int id;
    @NotBlank(message = "description can't be empty")
    private String description;
}
