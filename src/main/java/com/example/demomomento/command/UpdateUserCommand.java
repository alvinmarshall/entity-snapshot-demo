package com.example.demomomento.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserCommand {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
}
