package com.adventure;


import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenus{

    private int numberOfMenuOptions;
    private Narrator narrator;

    public GameMenus(Narrator narrator, int numberOfMenuOptions) {
        this.narrator = narrator;
        this.numberOfMenuOptions = numberOfMenuOptions;
    }

    public int runMainMenu(Hero hero) throws InterruptedException{

        int userEnteredMenuValue = 0;
        while (userEnteredMenuValue < 1 || userEnteredMenuValue > numberOfMenuOptions) {
            narrator.mainMenu(hero);
            userEnteredMenuValue = userEnterMenuValueAndCheckForException(numberOfMenuOptions);
        }
        return userEnteredMenuValue;
    }

    public void runQuestMenu(Hero hero) throws InterruptedException{
        int userEnteredMenuValue = 0;
        while (userEnteredMenuValue < 1 || userEnteredMenuValue > numberOfMenuOptions) {
            narrator.questMenu(hero);
            userEnteredMenuValue = userEnterMenuValueAndCheckForException(numberOfMenuOptions);
            if (userEnteredMenuValue != numberOfMenuOptions) {
                QuestEngine quest = new QuestEngine(narrator);
                quest.newQuest(userEnteredMenuValue, hero);
            }
        }
    }

    public void runCastleMenu(Hero hero) throws InterruptedException {
        int userEnteredMenuValue = 0;
        while (userEnteredMenuValue < 1 || userEnteredMenuValue > numberOfMenuOptions) {
            narrator.castleMenu(hero);
            userEnteredMenuValue = userEnterMenuValueAndCheckForException(numberOfMenuOptions);
            if (userEnteredMenuValue != numberOfMenuOptions) {
                CastleEngine castle = new CastleEngine(narrator);
                castle.goToThroneRoom(hero);
            }
        }
    }

    public int runBattleMenu(Hero hero) throws InterruptedException {
        narrator.battleMenu(hero);
        int userEnteredMenuValue = userEnterMenuValueAndCheckForException(numberOfMenuOptions);
        userEnteredMenuValue = hero.doesHeroHaveMp(hero, userEnteredMenuValue);
        return userEnteredMenuValue;
    }

    public int runDropItemMenu(String inventoryItem, Hero hero) throws InterruptedException{
        narrator.dropItemMenu(inventoryItem, hero);
        int userEnteredDropChoice = userEnterMenuValueAndCheckForException(numberOfMenuOptions);
        return userEnteredDropChoice;
    }

    private int userEnterMenuValueAndCheckForException(int numberOfMenuOptions) throws InterruptedException{
        int userEnteredValue = 0;
        try {
            Scanner reader1 = new Scanner(System.in);
            userEnteredValue = reader1.nextInt();
        } catch (InputMismatchException exception) {
            narrator.notAnInteger();
        }
        if (userEnteredValue < 1 || userEnteredValue > numberOfMenuOptions) {
            narrator.tryAgain();
        }
        return userEnteredValue;
    }

    public InventoryItems userEnterItemAndCheckForExceptionAndInventory(Hero hero) throws  InterruptedException {
        String userEnteredValue = "";
        InventoryItems removeItem = null;
        boolean isItemInInventory = false;
        Scanner reader1 = new Scanner(System.in);
        narrator.enterDropItemChoice();
        while (isItemInInventory == false) {
            userEnteredValue = reader1.nextLine();
            System.out.println(userEnteredValue);
            for (InventoryItems item : hero.getInventoryItems()) {
                if (userEnteredValue.equalsIgnoreCase(item.getItemName())){
                    isItemInInventory = true;
                    removeItem = item;
                } else {
                    isItemInInventory = false;
                }
            }
            if (isItemInInventory ==false) {
                narrator.notInInventory();
                narrator.enterDropItemChoice();
            }
        }
        return removeItem;
    }


}