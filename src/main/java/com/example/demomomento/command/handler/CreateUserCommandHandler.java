package com.example.demomomento.command.handler;

import com.example.demomomento.command.CreateUserCommand;
import com.example.demomomento.dto.CreateUserDto;
import com.example.demomomento.helper.UserCreationHelper;
import com.example.demomomento.mapper.UserDomainMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler {
    private final UserCreationHelper userCreationHelper;

    public CreateUserCommandHandler(UserCreationHelper userCreationHelper) {
        this.userCreationHelper = userCreationHelper;
    }

    public String execute(CreateUserDto input) {
        CreateUserCommand command = UserDomainMapper.createUserDtoToCommand(input);
        return userCreationHelper.createUser(command);
    }
}
