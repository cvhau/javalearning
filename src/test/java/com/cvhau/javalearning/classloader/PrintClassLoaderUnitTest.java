package com.cvhau.javalearning.classloader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrintClassLoaderUnitTest {
    @Test
    public void givenAppClassLoader_whenParentClassLoader_thenClassNotFoundException() throws Exception {
        PrintClassLoader printClassLoader = (PrintClassLoader) Class.forName(PrintClassLoader.class.getName())
                .getDeclaredConstructor().newInstance();

        printClassLoader.printClassLoaders();

        assertThrows(ClassNotFoundException.class, () -> {
            Class.forName(
                    PrintClassLoader.class.getName(),true, PrintClassLoader.class.getClassLoader().getParent()
            );
        });
    }
}
