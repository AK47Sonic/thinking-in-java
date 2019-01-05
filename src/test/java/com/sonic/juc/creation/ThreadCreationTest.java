package com.sonic.juc.creation;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ThreadCreation Tester.
 *
 * @author Sonic
 * @version 1.0
 */
public class ThreadCreationTest {

    @Test
    public void testThread() {
        ThreadCreation.MyThread myThread = new ThreadCreation.MyThread();
        myThread.start();
    }

    @Test
    public void testRunnable() {
        ThreadCreation.RunnableTask runnableTask = new ThreadCreation.RunnableTask();
        new Thread(runnableTask).start();
        new Thread(runnableTask).start();
    }

    @Test
    public void testCallable() {
        FutureTask<String> stringFutureTask = new FutureTask<>(new ThreadCreation.CallerTask());
        new Thread(stringFutureTask).start();

        try {
            String result = stringFutureTask.get();
            System.out.println("result: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
