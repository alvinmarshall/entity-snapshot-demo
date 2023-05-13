package com.example.demomomento.observer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyChange {
    private String propertyName;
    private Object oldValue;
    private Object newValue;
}
