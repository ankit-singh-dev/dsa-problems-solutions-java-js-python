package com.inn.multithreading;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueue {

    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
    private static int counter = 1;

    public static void main(String[] args) throws InterruptedException {

        Thread producer = new Thread(() -> {

            try {
                while(true) {
                    queue.put(counter);
                    Thread.sleep(500);
                    System.out.println("Push element =" + counter);
                    counter++;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {

            try {
                while (true) {
                    int element = queue.take();
                    Thread.sleep(500);
                    System.out.println("Pull element =" + element);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();

        //producer.join();
        //consumer.join();
    }
}
