package com.example.demomomento.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Data
@Builder
public class UserEntity {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Map<String, Object> history;
    private List<Map<String, Object>> histories;

    public void create() {
        if (this.id != null) throw new IllegalArgumentException("user is not in the correct state for create action!");
        this.id = UUID.randomUUID().toString();
        validateUser();
    }

    private void validateUser() {
        if (this.firstName == null) throw new IllegalArgumentException("firstname is required!");
        if (this.lastName == null) throw new IllegalArgumentException("lastName is required!");
        if (this.email == null) throw new IllegalArgumentException("email is required!");
    }

    private void initHistory() {
        if (histories == null) {
            histories = new ArrayList<>();
        }
        if (ObjectUtils.isEmpty(history)) return;
        history.put("updated_at", new Date());
        histories.add(history);
    }

    public void updateUser() {
        validateUser();
        initHistory();
    }

}
