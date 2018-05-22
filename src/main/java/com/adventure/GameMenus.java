package com.adventure;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameMenus{

    private int numberOfMenuOptions;

    public GameMenus(int numberOfMenuOptions) {
        this.numberOfMenuOptions = numberOfMenuOptions;
    }

    public int runMainMenu(Hero hero) {

        int userEnteredMenuValue = 0;
        while (userEnteredMenuValue < 1 || userEnteredMenuValue > numberOfMenuOptions) {

            System.out.println(hero.getHeroName() + ", what would you like to do?" + "\n");
            System.out.println("1.  Continue Your Quest");
            System.out.println("2.  Go to the Castle Courtyard");
            System.out.println("3.  View Status");
            System.out.println("4.  View Inventory");
            System.out.println("5.  Save Game");
            System.out.println("6.  End Game" + "\n");
            System.out.println("Enter the number of your choice.");
            userEnteredMenuValue = userEnterMenuValueAndCheckForException(numberOfMenuOptions);
        }
        return userEnteredMenuValue;
    }

    public void runQuestMenu(Hero hero) throws InterruptedException{
        int userEnteredMenuValue = 0;
        while (userEnteredMenuValue < 1 || userEnteredMenuValue > numberOfMenuOptions) {

            System.out.println("Where would you like to go?");
            System.out.println("1.  Quest 1" + "\n" + "2.  Quest 2" + "\n" + "3.  Quest 3" + "\n" + "4.  Quest 4" + "\n" + "5.  Quest 5" + "\n" + "6.  Back to main menu" + "\n");
            System.out.println("Enter the number of your choice.");
            userEnteredMenuValue = userEnterMenuValueAndCheckForException(numberOfMenuOptions);
            if (userEnteredMenuValue != 6) {
                QuestEngine quest = new QuestEngine();
                quest.newQuest(userEnteredMenuValue, hero);
            }
        }
    }

    public void runCastleMenu(Hero hero) throws InterruptedException {
        int userEnteredMenuValue = 0;
        while (userEnteredMenuValue < 1 || userEnteredMenuValue > numberOfMenuOptions) {

            System.out.println("Where would you like to go?");
            System.out.println("1.  Throne Room" + "\n" + "2.  Stables" + "\n" + "3.  Market" + "\n" + "4.  Gamble with Locals" + "\n" + "5.  Visit Oracle" + "\n" + "6.  Back to main menu" + "\n");
            System.out.println("Enter the number of your choice.");
            userEnteredMenuValue = userEnterMenuValueAndCheckForException(numberOfMenuOptions);
            if (userEnteredMenuValue != 6) {
                CastleEngine castle = new CastleEngine();
                castle.goToThroneRoom(hero);
            }
        }
    }

    public int runBattleMenu(Hero hero) {
        System.out.println(hero.getHeroName() + ", choose your action?");
        System.out.println("1.  Regular Attack");
        System.out.println("2.  Magic Attack");
        System.out.println("3.  Roll Dice");
        System.out.println("Enter the number of your choice.");
        int userEnteredMenuValue = userEnterMenuValueAndCheckForException(numberOfMenuOptions);
        userEnteredMenuValue = hero.doesHeroHaveMp(hero, userEnteredMenuValue);
        return userEnteredMenuValue;
    }

    public int runDropItemMenu(Hero hero, String inventoryItem) throws InterruptedException{
        System.out.println("Your backpack is full." + "\n");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println(hero.getHeroItemsInventory());
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Would you like to drop an item to make room for the " + inventoryItem + "?");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Enter 1 for Yes");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Enter 2 for No" + "\n");
        TimeUnit.MILLISECONDS.sleep(500);
        int userEnteredMenuValue = userEnterMenuValueAndCheckForException(numberOfMenuOptions);
        return userEnteredMenuValue;
    }

    private int userEnterMenuValueAndCheckForException(int numberOfMenuOptions){
        int userEnteredValue = 0;
        try {
            Scanner reader1 = new Scanner(System.in);
            userEnteredValue = reader1.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("This is not an integer.");
        }
        if (userEnteredValue < 1 || userEnteredValue > numberOfMenuOptions) {
            System.out.println("Not a valid choice.  Try again." + "\n");
        }
        return userEnteredValue;
    }
}