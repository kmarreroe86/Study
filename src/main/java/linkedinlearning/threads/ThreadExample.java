package linkedinlearning.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {

        ThreadTest t = new ThreadTest();
        t.setName("My first thread");
        t.start();

        ThreadTest t2 = new ThreadTest();
        t2.setName("My second thread");
        t2.start();
        t.join();
        t2.join();

        Counter counter = new Counter();
        Thread counterFirst = new Thread(counter, "CounterFirst");
        Thread counterSecond = new Thread(counter, "CounterSecond");

        counterFirst.start();
        counterSecond.start();
        counterFirst.join();    // main thread will wait to this thread to die to resume its execution
        counterSecond.join();    // main thread will wait to this thread to die to resume its execution

        System.out.println(counter.counter);
    }

}

class ThreadTest extends Thread {

    @Override
    public void run() {
        int i = 0;
        while (i <= 100) {
            System.out.println(i + " " + this.getName());
            i++;
        }
    }
}


class Counter extends Thread {
    AtomicInteger counter = new AtomicInteger();

    public void run() {
        for (int i = 0; i < 100_000_000; i++) {
            counter.addAndGet(1);
        }
    }

}
