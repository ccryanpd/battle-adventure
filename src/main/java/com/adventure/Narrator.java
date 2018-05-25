package com.adventure;

import java.util.List;

public class Narrator {

    public Sleep sleep = new Sleep();

    public void storyNarrator(List<String> beginningNarrative) throws InterruptedException {

        for (String line : beginningNarrative) {
            System.out.println(line);
            sleep.mediumSleep();
        }
        System.out.println();
    }
}