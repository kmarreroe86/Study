package locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiveLockMain {

    public static void main(String[] args) {
// Create participants and resources
        Fox2 robin = new Fox2();
        Fox2 miki = new Fox2();
        Food2 food = new Food2();
        Water2 water = new Water2();
// Process data
        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> robin.eatAndDrink(food, water));
            service.submit(() -> miki.drinkAndEat(food, water));
        } finally {
            if (service != null) service.shutdown();
        }
    }
}

class Food2 {
}

class Water2 {
}

class Fox2 {
    public void eatAndDrink(Food2 food, Water2 water) {
        synchronized (food) {
            System.out.println("Got Food!");
            move();
        }
        drinkAndEat(food, water);
    }

    public void drinkAndEat(Food2 food, Water2 water) {
        synchronized (water) {
            System.out.println("Got Water!");
            move();
        }
        eatAndDrink(food, water);
    }

    public void move() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
// Handle exception
        }
    }
}
