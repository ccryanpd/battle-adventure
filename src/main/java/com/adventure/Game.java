package com.adventure;

public class Game {

    private Hero hero;
    private GameTextOutput gameTextOutput;
    private boolean isGameRunning;

    public Game () {
        this.isGameRunning = true;
        this.hero = new Hero();
        this.gameTextOutput = new GameTextOutput();
    }

    public void gameEngine() throws InterruptedException{

        gameTextOutput.beginningNarrative(hero);
        while (isGameRunning) {

            GameMenus gameMenu = new GameMenus(6);
            int userEnteredMainMenuValue = gameMenu.runMainMenu(hero);

            switch (userEnteredMainMenuValue) {

                case 1:
                    gameMenu = new GameMenus(6);
                    gameMenu.runQuestMenu(hero);
                    isGameRunning = (hero.getHeroHp() > 0);
                    break;

                case 2:
                    gameMenu = new GameMenus(6);
                    gameMenu.runCastleMenu(hero);
                    break;

                case 3:
                    hero.printHeroStatus();
                    break;

                case 4:
                    InventoryItems inventoryItems = new InventoryItems();
                    inventoryItems.printHeroInventory(hero);
                    break;

                case 5:

                    break;
                case 6:
                    isGameRunning = false;
                    break;
            }
        }
        gameTextOutput.thankYou();
    }
}

