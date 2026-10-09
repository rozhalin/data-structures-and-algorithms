package lesson_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


public class DataBase {

    private final List<String> data = new ArrayList<>();
    @SuppressWarnings("rawtypes")
    private final Map<Class, Function<String, Object>> mappers = new HashMap<>();

    @SuppressWarnings("rawtypes")
    public void addMapper(Class clss, Function<String, Object> mapper) {
        mappers.put(clss, mapper);
    }

    public void add(Object ob) {
        data.add(ob.toString());
    }

    @SuppressWarnings("unchecked")
    public <T> T get(int index, Class<T> clss) {
        return (T) mappers
                    .get(clss)
                    .apply(data.get(index));
    }
}
