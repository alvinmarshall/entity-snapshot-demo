package com.example.demomomento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmailDto implements Serializable {
    private String id;
    private String email;
}
