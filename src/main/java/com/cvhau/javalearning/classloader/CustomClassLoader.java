package com.cvhau.javalearning.classloader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b;
        try {
            b = loadClassFromName(name);
        } catch (IOException exception) {
            throw new ClassNotFoundException(exception.getMessage(), exception);
        }
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassFromName(String className) throws IOException {
        // Convert class name to binary class path
        String binaryPath = className.replace('.', File.separatorChar) + ".class";
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(binaryPath)) {
            if (inputStream != null) {
                return inputStream.readAllBytes();
            }
            throw new IOException("The resource " + binaryPath + " could not be found or permission denied.");
        }
    }
}
