package com.example.demomomento.observer;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyObserver<T> {
    private final Map<String, Object> oldProperties = new HashMap<>();
    private final Map<String, Object> newProperties = new HashMap<>();
    private final List<PropertyChangeListener> listeners = new ArrayList<>();

    public void setOldData(T oldData) {
        Map<String, Object> classProperties = getClassProperties(oldData);
        oldProperties.putAll(classProperties);
    }

    public void addListener(PropertyChangeListener listener) {
        listeners.add(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        listeners.remove(listener);
    }

    public void setProperty(String propertyName, Object newValue) {
        Object oldValue = oldProperties.get(propertyName);
        if (oldValue.equals(newValue)) return;
        newProperties.put(propertyName, newValue);
        firePropertyChange(new PropertyChange(propertyName, oldValue, newValue));
    }

    private void firePropertyChange(PropertyChange change) {
        for (PropertyChangeListener listener : listeners) {
            listener.onPropertyChange(change);
        }
    }

    public Object getProperty(String propertyName) {
        return newProperties.get(propertyName);
    }

    public void handleUpdateRequest(T data) {
        Map<String, Object> newValues = getClassProperties(data);
        for (Map.Entry<String, Object> entry : newValues.entrySet()) {
            String propertyName = entry.getKey();
            Object newValue = entry.getValue();
            this.setProperty(propertyName, newValue);
        }
    }

    @SneakyThrows
    private Map<String, Object> getClassProperties(T data) {
        Map<String, Object> newValues = new HashMap<>();
        Field[] allFields = data.getClass().getDeclaredFields();
        for (Field field : allFields) {
            field.setAccessible(true);
            Object value = field.get(data);
            newValues.put(field.getName(), value);
        }
        return newValues;
    }
}

