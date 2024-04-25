package locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StarvationLock {

    public static void main(String[] args) {
// Create participants and resources
        Fox3 robin = new Fox3();
        Fox3 miki = new Fox3();
        Elephant dumbo = new Elephant();
        Food3 food = new Food3();
// Process data
        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> dumbo.eat(food));
            service.submit(() -> robin.eat(food));
            service.submit(() -> miki.eat(food));
        } finally {
            if (service != null) service.shutdown();
        }
    }
}

class Food3 {
}

class Elephant {
    public void eat(Food3 food) {
        synchronized (food) {
            System.out.println("Elephant got Food!");
            try {
                Thread.sleep(60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Fox3 {
    public void eat(Food3 food) {
        move();
        synchronized (food) {
            System.out.println("Got Food!");
        }
    }

    public void move() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // Handle exception
        }
    }
}
