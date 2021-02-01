package com.cvhau.javalearning.reflection;

public class PrivatePerson extends Person {
    /**
     * Prevent other user create new Person2 object directly
     */
    private PrivatePerson(String name, int age) {
        super(name, age);
    }
}
