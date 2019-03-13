package com.example.demo.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtils {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static void execute(Runnable runnable){
        executorService.submit(runnable);
    }
}
