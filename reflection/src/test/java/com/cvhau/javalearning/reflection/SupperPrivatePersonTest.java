package com.cvhau.javalearning.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SupperPrivatePersonTest {
    @Test
    public void createObject_SetPrivateConstructorAccessible_ExceptionThrow() throws Exception {
        Class<?> cls = Class.forName(SupperPrivatePerson.class.getName());
        Constructor<?> constructor = cls.getDeclaredConstructor(String.class, Integer.TYPE);
        // Set accessible on private constructor, so we will access it normal.
        constructor.setAccessible(true);
        assertThrows(Exception.class, () -> {
            SupperPrivatePerson person = (SupperPrivatePerson) constructor.newInstance("A Person", 100);
            System.out.println(person.toString());
        });
    }
}