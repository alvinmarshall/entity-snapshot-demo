package com.example.demomomento.command.handler;

import com.example.demomomento.command.UpdateUserCommand;
import com.example.demomomento.dto.UpdateUserDto;
import com.example.demomomento.helper.UserUpdateHelper;
import com.example.demomomento.mapper.UserDomainMapper;
import org.springframework.stereotype.Component;

@Component
public class UpdateCommandHandler {
    private final UserUpdateHelper userUpdateHelper;

    public UpdateCommandHandler(UserUpdateHelper userUpdateHelper) {
        this.userUpdateHelper = userUpdateHelper;
    }

    public void execute(UpdateUserDto input) {
        UpdateUserCommand command = UserDomainMapper.updateUserDtoToCommand(input);
        userUpdateHelper.updateUser(command);
    }
}
