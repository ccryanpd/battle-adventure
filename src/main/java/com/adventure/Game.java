package com.adventure;

import java.io.IOException;

public class Game {

    private Hero hero;
    private boolean isGameRunning;
    private Narrator narrator;

    public Game(Narrator narrator) throws InterruptedException {
        this.isGameRunning = true;
        this.narrator = narrator;
        this.hero = new Hero(narrator);
    }

    public void gameEngine() throws InterruptedException, IOException, NullPointerException{
        narrator.beginningNarrative(hero);
        while (isGameRunning) {

            GameMenus gameMenu = new GameMenus(narrator, 6);
            int userEnteredMainMenuValue = gameMenu.runMainMenu(hero);

            switch (userEnteredMainMenuValue) {

                case 1:
                    gameMenu = new GameMenus(narrator, 6);
                    gameMenu.runQuestMenu(hero);
                    isGameRunning = (hero.getHeroHp() > 0);
                    break;

                case 2:
                    gameMenu = new GameMenus(narrator, 6);
                    gameMenu.runCastleMenu(hero);
                    break;

                case 3:
                    narrator.printHeroStatus(hero);
                    break;

                case 4:
                    narrator.printHeroInventory(hero);
                    break;

                case 5:

                    break;
                case 6:
                    isGameRunning = false;
                    break;
            }
        }
        narrator.thankYou();
    }
}

