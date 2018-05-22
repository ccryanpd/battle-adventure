package com.adventure;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {


    public static void main (String[] args) throws InterruptedException {
        SpringApplication.run(MainApplication.class, args);

    }

    @Override
    public void run(String... args) throws InterruptedException {

        Game game = new Game();
        game.gameEngine();

    }
}
