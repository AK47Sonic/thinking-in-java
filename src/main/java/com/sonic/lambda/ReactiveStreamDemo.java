package com.sonic.lambda;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 * ReactiveStreamDemo
 *
 * @author Sonic
 * @since 2020/2/21
 */
public class ReactiveStreamDemo {

    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                System.out.println("onSubscribe");
                subscription.request(1);

            }

            @Override
            public void onNext(Integer item) {
                System.out.println(Thread.currentThread().getName() + ": " + item);

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                this.subscription.request(1);

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println(Thread.currentThread().getName() + " all is completed");
            }
        };

        publisher.subscribe(subscriber);

        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " submit: " + i);
            publisher.submit(i);
        }

        publisher.close();

        TimeUnit.SECONDS.sleep(600);
    }

}
