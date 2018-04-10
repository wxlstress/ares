package test;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;

public class TokenBucketAlgorithm  implements Runnable{
    public static void main(String[] args) {
        new TokenBucketAlgorithm().run();
    }

    @Override
    public void run() {
        RateLimiter limiter = RateLimiter.create(2);
        System.out.println(limiter.acquire());
        try {
            Thread.sleep(2000L);
            System.out.println(limiter.acquire());
            System.out.println(limiter.acquire());
            System.out.println(limiter.acquire());
            System.out.println(limiter.acquire());
            System.out.println(limiter.acquire());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}