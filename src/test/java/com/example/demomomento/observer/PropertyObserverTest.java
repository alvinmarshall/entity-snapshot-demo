package com.example.demomomento.observer;

import com.example.demomomento.dto.CreateUserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class PropertyObserverTest {
    private PropertyObserver<CreateUserDto> dtoPropertyObserver;

    @BeforeEach
    void setUp() {
        dtoPropertyObserver = new PropertyObserver<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldDetectFirstNameChange() {
        CreateUserDto oldDto = CreateUserDto.builder()
                .firstName("fname")
                .lastName("lname")
                .email("test@me.com")
                .build();

        CreateUserDto userDto = CreateUserDto.builder()
                .firstName("update name")
                .lastName("lname")
                .email("testme@.com")
                .build();
        dtoPropertyObserver.setOldData(oldDto);

        dtoPropertyObserver
                .addListener(change -> Assertions.assertNotEquals("update name", change.getOldValue()));
        dtoPropertyObserver.handleUpdateRequest(userDto);
    }
}
