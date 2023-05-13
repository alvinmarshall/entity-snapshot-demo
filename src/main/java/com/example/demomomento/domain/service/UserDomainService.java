package com.example.demomomento.domain.service;

import com.example.demomomento.domain.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserDomainService {
    public void create(UserEntity entity) {
        entity.create();
    }

    public void updateUser(UserEntity entity) {
        entity.updateUser();
    }
}
