package com.example.demomomento.mapper;

import com.example.demomomento.command.CreateUserCommand;
import com.example.demomomento.command.UpdateUserCommand;
import com.example.demomomento.data.User;
import com.example.demomomento.domain.UserEntity;
import com.example.demomomento.dto.CreateUserDto;
import com.example.demomomento.dto.UpdateUserDto;

public class UserDomainMapper {
    private UserDomainMapper() {
    }

    public static UserEntity userToEntity(User input) {
        return UserEntity
                .builder()
                .id(input.getId())
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .email(input.getEmail())
                .histories(input.getHistories())
                .build();
    }

    public static User entityToModel(UserEntity input) {
        return User
                .builder()
                .id(input.getId())
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .email(input.getEmail())
                .histories(input.getHistories())
                .build();
    }

    public static UserEntity createUserCommandToEntity(CreateUserCommand command) {
        return UserEntity.builder()
                .firstName(command.getFirstName())
                .lastName(command.getLastName())
                .email(command.getEmail())
                .build();
    }

    public static CreateUserCommand createUserDtoToCommand(CreateUserDto input) {
        return CreateUserCommand.builder()
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .email(input.getEmail())
                .build();
    }

    public static UpdateUserCommand updateUserDtoToCommand(UpdateUserDto input) {
        return UpdateUserCommand.builder()
                .userId(input.getId())
                .email(input.getEmail())
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .build();
    }
}
