package com.cvhau.javalearning.reflection.inspecting;

import org.bouncycastle.crypto.util.Pack;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class GoatTest {
    @Test
    public void givenObject_whenGetsClassName_thenCorrect() {
        Object goat = new Goat("goat");
        Class<?> clazz = goat.getClass();

        assertAll(
                () -> assertEquals("Goat", clazz.getSimpleName()),
                () -> assertEquals("com.cvhau.javalearning.reflection.inspecting.Goat", clazz.getName()),
                () -> assertEquals("com.cvhau.javalearning.reflection.inspecting.Goat", clazz.getCanonicalName())
        );
    }

    @Test
    public void givenClassName_whenCreatesObject_thenCorrect() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.cvhau.javalearning.reflection.inspecting.Goat");

        assertAll(
                () -> assertEquals("Goat", clazz.getSimpleName()),
                () -> assertEquals("com.cvhau.javalearning.reflection.inspecting.Goat", clazz.getName()),
                () -> assertEquals("com.cvhau.javalearning.reflection.inspecting.Goat", clazz.getCanonicalName())
        );
    }

    @Test
    public void givenClass_whenRecognisesModifiers_thenCorrect() throws ClassNotFoundException {
        Class<?> animalClass = Class.forName("com.cvhau.javalearning.reflection.inspecting.Animal");
        Class<?> goatClass = Class.forName("com.cvhau.javalearning.reflection.inspecting.Goat");

        int animalClassModifiers = animalClass.getModifiers();
        int goatClassModifiers = goatClass.getModifiers();

        System.out.println("animalClassModifiers: " + animalClassModifiers);
        System.out.println("goatClassModifiers: " + goatClassModifiers);

        assertAll(
                () -> assertTrue(Modifier.isAbstract(animalClassModifiers)),
                () -> assertTrue(Modifier.isPublic(animalClassModifiers)),
                () -> assertTrue(Modifier.isPublic(goatClassModifiers))
        );
    }

    @Test
    public void givenClass_whenGetsPackageInfo_thenCorrect() {
        Goat goat = new Goat("Goat");
        Class<?> clazz = goat.getClass();
        Package pkg = clazz.getPackage();

        assertEquals("com.cvhau.javalearning.reflection.inspecting", pkg.getName());
    }
}