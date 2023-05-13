package com.example.demomomento.controller;

import com.example.demomomento.command.handler.CreateUserCommandHandler;
import com.example.demomomento.command.handler.UpdateCommandHandler;
import com.example.demomomento.dto.CreateUserDto;
import com.example.demomomento.dto.UpdateUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UsersController {
    private final CreateUserCommandHandler createUserCommandHandler;
    private final UpdateCommandHandler updateCommandHandler;

    public UsersController(CreateUserCommandHandler createUserCommandHandler, UpdateCommandHandler updateCommandHandler) {
        this.createUserCommandHandler = createUserCommandHandler;
        this.updateCommandHandler = updateCommandHandler;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody CreateUserDto input) {
        String userId = createUserCommandHandler.execute(input);
        return new ResponseEntity<>(userId, HttpStatus.CREATED);
    }

    @PutMapping("{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable("userId") String userId, @RequestBody UpdateUserDto input) {
        input.setId(userId);
        updateCommandHandler.execute(input);
        return ResponseEntity.ok(true);
    }
}
