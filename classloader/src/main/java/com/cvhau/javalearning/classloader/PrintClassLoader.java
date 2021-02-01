package com.cvhau.javalearning.classloader;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.logging.Logger;

public class PrintClassLoader {

    public void printClassLoaders() {
        System.out.println("Classloader of this class: " + PrintClassLoader.class.getClassLoader());
        System.out.println("Parent Classloader of this class: " + PrintClassLoader.class.getClassLoader().getParent());

        System.out.println("Classloader of Logger: " + Logger.class.getClassLoader());
        System.out.println("Classloader of ArrayList: " + ArrayList.class.getClassLoader());
        System.out.println("Classloader of " + ArrayUtils.class.getName() + ": " + ArrayUtils.class.getClassLoader());

        Thread currentThread = Thread.currentThread();

        System.out.println("Classloader of java.lang.Thread: " + currentThread.getClass().getClassLoader());
        System.out.println("Classloader of current thread context: " + currentThread.getContextClassLoader());
    }
}
