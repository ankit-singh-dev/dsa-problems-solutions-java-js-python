package com.inn.multithreading;

public class Synchronization {

    private static int counter = 0;

    public static void main(String[] args) {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                incrementCounter();
            }
        });

        Thread two = new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                incrementCounter();
            }
        });

        one.start();
        two.start();


        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter Value===" + counter);
    }

    private  static void incrementCounter() {
        synchronized (Synchronization.class) {
            counter++;
        }
    }


}
