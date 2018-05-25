package com.adventure;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class Game {


    private Hero hero;
    private GameText gameText;
    private boolean isGameRunning;

    public Game(GameText gameText) {
        this.isGameRunning = true;
        this.hero = new Hero(gameText);
        this.gameText = gameText;
    }

    public void gameEngine() throws InterruptedException, IOException, NullPointerException{

        gameText.beginningNarrative(hero);
        while (isGameRunning) {

            GameMenus gameMenu = new GameMenus(6, gameText);
            int userEnteredMainMenuValue = gameMenu.runMainMenu(hero);

            switch (userEnteredMainMenuValue) {

                case 1:
                    gameMenu = new GameMenus(6, gameText);
                    gameMenu.runQuestMenu(hero);
                    isGameRunning = (hero.getHeroHp() > 0);
                    break;

                case 2:
                    gameMenu = new GameMenus(6, gameText);
                    gameMenu.runCastleMenu(hero);
                    break;

                case 3:
                    hero.printHeroStatus();
                    break;

                case 4:
                    InventoryItems inventoryItems = new InventoryItems(gameText);
                    inventoryItems.printHeroInventory(hero);
                    break;

                case 5:

                    break;
                case 6:
                    isGameRunning = false;
                    break;
            }
        }
        gameText.thankYou();
    }
}

