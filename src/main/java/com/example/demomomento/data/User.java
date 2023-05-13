package com.example.demomomento.data;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class User {
    @Id
    private String id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private String email;

    @ToString.Exclude
    @Builder.Default
    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private List<Map<String, Object>> histories = new ArrayList<>();
}
