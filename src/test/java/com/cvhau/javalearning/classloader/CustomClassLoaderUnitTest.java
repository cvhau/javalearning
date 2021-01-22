package com.cvhau.javalearning.classloader;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CustomClassLoaderUnitTest {
    @Test
    public void testCustomClassLoader() {
        assertDoesNotThrow(() -> {
            CustomClassLoader customClassLoader = new CustomClassLoader();
            Class<?> cls = customClassLoader.findClass(PrintClassLoader.class.getName());

            Object obj = cls.getDeclaredConstructor().newInstance();

            Method method = cls.getMethod("printClassLoaders");
            method.invoke(obj);
        });
    }
}