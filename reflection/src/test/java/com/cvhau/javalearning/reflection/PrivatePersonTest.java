package com.cvhau.javalearning.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrivatePersonTest {
    @Test
    public void createObject_OnPrivateConstructor_ExceptionThrow() throws Exception {
        Class<?> cls = Class.forName(PrivatePerson.class.getName());
        Constructor<?> privateConstructor = cls.getDeclaredConstructor(String.class, Integer.TYPE);
        assertThrows(IllegalAccessException.class, () -> {
            // IllegalAccessException will throw here because the constructor is not accessible
            PrivatePerson privatePerson = (PrivatePerson) privateConstructor.newInstance("A Person", 100);
            System.out.println(privatePerson.toString());
        });
    }

    @Test
    public void createObject_SetPrivateConstructorAccessible_NonExceptionThrow() throws Exception {
        Class<?> cls = Class.forName(PrivatePerson.class.getName());
        Constructor<?> privateConstructor = cls.getDeclaredConstructor(String.class, Integer.TYPE);
        // Set accessible on private constructor, so we will access it normal.
        privateConstructor.setAccessible(true);
        assertDoesNotThrow(() -> {
            PrivatePerson privatePerson = (PrivatePerson) privateConstructor.newInstance("A Person", 100);
            System.out.println(privatePerson.toString());
        });
    }
}
