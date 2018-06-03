package com.adventure;

import java.util.concurrent.TimeUnit;

public class Sleep {

    public void attackActionSleep () throws InterruptedException {
        shortSleep();
        for (int count = 1; count < 5; count++){
            System.out.println("... ");
            shortSleep();
        }
    }

    public void shortSleep() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(250);
    }

    public void mediumSleep() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(800);
    }

    public void longSleep() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }
}
