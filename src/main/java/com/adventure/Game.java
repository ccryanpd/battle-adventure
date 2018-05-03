package com.adventure;

import java.util.ArrayList;

public class Game {

    private boolean isGameRunning = true;
    private int userEnteredMainMenuValue = 0;


    public void gameEngine() throws InterruptedException{

        Hero hero = new Hero(1, 1, 0, 0, 10, 5, 5, 5, 5, 0,  0);



        Story story = new Story();
        story.beginningNarrative(hero);
        while (isGameRunning) {

            GameMenus gameMenu = new GameMenus();
            userEnteredMainMenuValue = gameMenu.runMainMenu(hero);

            switch (userEnteredMainMenuValue) {

                case 1:
                    gameMenu.runQuestMenu(hero);
                    userEnteredMainMenuValue = 0;
                    isGameRunning = hero.isHeroAlive(hero);
                    break;

                case 2:
                    gameMenu.runCastleMenu(hero);
                    userEnteredMainMenuValue = 0;

                    break;
                case 3:
                    hero.printHeroStatus();
                    userEnteredMainMenuValue = 0;

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    isGameRunning = false;
                    break;
            }
        }
    }





}

