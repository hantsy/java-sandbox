/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * @author hantsy
 */
public class VirtualThreadExample {

    public static final void main(String args[]) throws Exception {
        //ExecutorService executor = Executors.newFixedThreadPool(10);
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        var tasks = IntStream.range(1, 1_000_000)
                .mapToObj(SimpleTask::new)
                .toList();
        var start = System.currentTimeMillis();

        var futures = executor.invokeAll(tasks);

        long sum = 0;
        for (Future<Integer> f : futures) {
            sum += f.get();
        }

        var time = System.currentTimeMillis() - start;
        System.out.println("sum = " + sum + ", time = " + time + "ms");

        executor.shutdown();
    }
}

class SimpleTask implements Callable<Integer> {
    private int number;

    public SimpleTask(int number) {
        this.number = number;
    }

    @Override
    public Integer call() {
        System.out.printf("Thread %s - Task %d waiting ... %n", Thread.currentThread().getName(), number);

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s - Task %d cancelled. %n", Thread.currentThread().getName(), number);
            return -1;
        }
        System.out.printf("Thread %s - Task %d finished. %n", Thread.currentThread().getName(), number);

        return number;
    }
}