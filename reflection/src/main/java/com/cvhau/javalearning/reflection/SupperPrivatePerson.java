package com.cvhau.javalearning.reflection;

public class SupperPrivatePerson extends Person {
    private SupperPrivatePerson(String name, int age) {
        throw new AssertionError(String.format("No %s instance for you!", SupperPrivatePerson.class.getSimpleName()));
    }
}
