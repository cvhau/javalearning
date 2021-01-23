package com.cvhau.javalearning.reflection.inspecting;

public abstract class Animal implements Eating {
    public static String CATEGORY = "domestic";
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected abstract String getSound();
}
