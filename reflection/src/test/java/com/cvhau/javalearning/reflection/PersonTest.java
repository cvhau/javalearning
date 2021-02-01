package com.cvhau.javalearning.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PersonTest {
    @Test
    public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
        Object person = new Person("A Person", 100);
        Field[] fields = person.getClass().getDeclaredFields();
        String[] actualFieldNames = getFieldNames(fields);
        String[] expectedFields = {"name", "age"};
        assertArrayEquals(actualFieldNames, expectedFields);
    }

    private static String[] getFieldNames(Field[] fields) {
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            fieldNames[i] = field.getName();
        }
        return fieldNames;
    }
}