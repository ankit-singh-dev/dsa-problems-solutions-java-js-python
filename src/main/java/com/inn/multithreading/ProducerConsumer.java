package com.inn.multithreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

    private static final List<Integer> shared = new ArrayList<>();
    private static int counter = 1;
    private static final Object LOCK = new Object();

    public static void main(String[] args) {


        Thread producer = new Thread(() -> {
            synchronized (LOCK) {
                while (true) {
                    if (shared.size() == 10) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        System.out.println("Producing counter ==" + counter);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        shared.add(counter);
                        counter++;
                        LOCK.notify();
                    }
                }
            }
        });

        Thread consumer = new Thread(() -> {
            synchronized (LOCK) {
                while (true) {
                    if (shared.isEmpty()) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        System.out.println("Consuming counter ==" + shared.get(shared.size() - 1));
                        shared.remove(shared.size() - 1);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        LOCK.notify();
                    }
                }
            }
        });

        producer.start();
        consumer.start();
    }

}
