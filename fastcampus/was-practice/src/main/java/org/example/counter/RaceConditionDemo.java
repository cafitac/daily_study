package org.example.counter;

public class RaceConditionDemo {

    public static void main(String[] args) {
        final Counter counter = new Counter();
        final Thread t1 = new Thread(counter, "Thread 1");
        final Thread t2 = new Thread(counter, "Thread 2");
        final Thread t3 = new Thread(counter, "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
