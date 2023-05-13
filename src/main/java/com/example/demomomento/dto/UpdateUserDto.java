package com.example.demomomento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
