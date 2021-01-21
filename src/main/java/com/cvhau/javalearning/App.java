package com.cvhau.javalearning;

import com.cvhau.javalearning.classloader.PrintClassLoader;

public class App {
    public static void main( String[] args ) throws ClassNotFoundException {
        PrintClassLoader.printClassLoader(App.class);

        ClassLoader classLoader = App.class.getClassLoader();
        Class<?> loadedClass = classLoader.loadClass(PrintClassLoader.class.getName());
        System.out.println(loadedClass);
    }
}
