package com.cvhau.javalearning.classloader;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.logging.Logger;

public class PrintClassLoader {

    public static void printClassLoader(Class<?> primarySource) {
        if (primarySource != null) {
            System.out.println("ClassLoader of primary class (" + primarySource.getName() + "): " + primarySource.getClassLoader());
        }
        System.out.println("Classloader of this class (PrintClassLoader): " + PrintClassLoader.class.getClassLoader());

        System.out.println("Classloader of Logger: " + Logger.class.getClassLoader());
        System.out.println("Classloader of ArrayList: " + ArrayList.class.getClassLoader());
        System.out.println("Classloader of " + ArrayUtils.class.getName() + ": " + ArrayUtils.class.getClassLoader());

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        System.out.println("Classloader of java.lang.Thread: " + Thread.currentThread().getClass().getClassLoader());
        System.out.println("Classloader of current thread context: " + contextClassLoader);
    }

    public static void printClassLoader() {
        printClassLoader(null);
    }
}
