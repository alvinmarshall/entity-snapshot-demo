package com.example.demomomento.helper;

import com.example.demomomento.command.UpdateUserCommand;
import com.example.demomomento.data.User;
import com.example.demomomento.data.repository.UserRepository;
import com.example.demomomento.domain.UserEntity;
import com.example.demomomento.domain.service.UserDomainService;
import com.example.demomomento.mapper.UserDomainMapper;
import com.example.demomomento.observer.PropertyObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class UserUpdateHelper {
    private final UserRepository userRepository;
    private final UserDomainService userDomainService;

    public UserUpdateHelper(UserRepository userRepository, UserDomainService userDomainService) {
        this.userRepository = userRepository;
        this.userDomainService = userDomainService;
    }

    public void updateUser(UpdateUserCommand command) {
        User user = checkUser(command.getUserId());
        PropertyObserver<UpdateUserCommand> propertyObserver = new PropertyObserver<>();
        UpdateUserCommand oldUser = UpdateUserCommand.builder().userId(user.getId()).build();
        BeanUtils.copyProperties(user, oldUser);
        propertyObserver.setOldData(oldUser);

        Map<String, Object> changeProps = new HashMap<>();
        propertyObserver.addListener(change -> changeProps.put(change.getPropertyName(), change.getOldValue()));
        propertyObserver.handleUpdateRequest(command);
        UserEntity entity = UserDomainMapper.userToEntity(user);

        entity.setEmail(command.getEmail());
        entity.setFirstName(command.getFirstName());
        entity.setLastName(command.getLastName());
        entity.setHistory(changeProps);

        userDomainService.updateUser(entity);

        User model = UserDomainMapper.entityToModel(entity);
        userRepository.save(model);
    }

    public User checkUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user not found!"));
    }
}
