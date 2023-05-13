package com.example.demomomento.helper;

import com.example.demomomento.command.CreateUserCommand;
import com.example.demomomento.data.User;
import com.example.demomomento.data.repository.UserRepository;
import com.example.demomomento.domain.UserEntity;
import com.example.demomomento.domain.service.UserDomainService;
import com.example.demomomento.mapper.UserDomainMapper;
import org.springframework.stereotype.Component;

@Component
public class UserCreationHelper {
    private final UserRepository userRepository;
    private final UserDomainService userDomainService;

    public UserCreationHelper(UserRepository userRepository, UserDomainService userDomainService) {
        this.userRepository = userRepository;
        this.userDomainService = userDomainService;
    }

    public String createUser(CreateUserCommand command) {
        UserEntity userEntity = UserDomainMapper.createUserCommandToEntity(command);
        userDomainService.create(userEntity);
        User user = UserDomainMapper.entityToModel(userEntity);
        userRepository.save(user);
        return user.getId();
    }
}
