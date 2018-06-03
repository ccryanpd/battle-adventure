package com.adventure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    public Narrator narrator;

    public static void main (String[] args) throws InterruptedException {

        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException, IOException, NullPointerException{

        Game game = new Game(narrator);
        game.gameEngine();

    }
}
