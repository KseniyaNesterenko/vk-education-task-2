package org.example;

import java.util.HashMap;
import java.util.Map;

public class TestDataRegistry {
    private static final Map<String, Object> registry = new HashMap<>();

    public static void put(String key, Object value) {
        registry.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return (T) registry.get(key);
    }

    public static void clear() {
        registry.clear();
    }
}