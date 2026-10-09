package lesson_9;

import java.util.HashMap;
import java.util.Map;

public class Register {

    private final Map<Class<?>, Object> dependencies = new HashMap<>();

    public <T> void reg(Class<T> type, T dependency) {
        if (type == null || dependency == null) {
            throw new IllegalArgumentException("Type or dependency cannot be null");
        }
        dependencies.put(type, dependency);
    }

    public <T> T lookUp(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        @SuppressWarnings("unchecked")
        T dependency = (T) dependencies.get(type);
        if (dependency == null) {
            throw new RuntimeException(
                    "There is no dependency for type: " + type.getName()
            );
        }
        return dependency;
    }
}
