package lesson_12;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataBaseTest {

    private DataBase db;

    @BeforeEach
    void setUp() {
        db = new DataBase();
    }

    @Test
    void testAddAndGetString() {
        String input = "Hello";
        db.add(input);
        db.addMapper(String.class, x -> x);

        String result = db.get(0, String.class);
        assertEquals(input, result);
    }

    @Test
    void testAddIntegerAndGetInteger() {
        int value = 42;
        db.add(value);
        db.addMapper(Integer.class, Integer::parseInt);

        Integer result = db.get(0, Integer.class);
        assertEquals(Integer.valueOf(value), result);
    }

    @Test
    void testGetWithDifferentTypesFromSameString() {
        db.add("123");
        db.addMapper(String.class, x -> x);
        db.addMapper(Integer.class, Integer::parseInt);

        String asString = db.get(0, String.class);
        Integer asInt = db.get(0, Integer.class);

        assertEquals("123", asString);
        assertEquals(Integer.valueOf(123), asInt);
    }
}