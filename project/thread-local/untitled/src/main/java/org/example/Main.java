package org.example;

public class Main {

    private static final ThreadLocal<String> firstThreadLocal;
    private static final ThreadLocal<String> secondThreadLocal;

    static {
        firstThreadLocal = new ThreadLocal<>();
        secondThreadLocal = new ThreadLocal<>();
    }

    public static void main(String[] args) {
        firstThreadLocal.set("first");
        secondThreadLocal.set("second");

        final String s1 = firstThreadLocal.get();
        final String s2 = secondThreadLocal.get();

        System.out.println(s1);
        System.out.println(s2);
    }
}