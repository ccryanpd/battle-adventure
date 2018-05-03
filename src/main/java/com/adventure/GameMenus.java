package com.adventure;


import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenus{

    public int runMainMenu(Hero hero) {

        int userEnteredMainMenuValue = 0;
        while (userEnteredMainMenuValue < 1 || userEnteredMainMenuValue > 6) {

            System.out.println(hero.getHeroName() + ", what would you like to do?" + "\n");
            System.out.println("1.  Continue Your Quest");
            System.out.println("2.  Go to the Castle Courtyard");
            System.out.println("3.  View Status");
            System.out.println("4.  View Inventory");
            System.out.println("5.  Save Game");
            System.out.println("6.  End Game" + "\n");
            System.out.println("Enter the number of your choice.");
            userEnteredMainMenuValue = userEnterMenuChoiceAndCheckForException();
            printsDirectionToPlayerToPickAValidMainMenuChoice(userEnteredMainMenuValue);
        }
        return userEnteredMainMenuValue;
    }

    public void runQuestMenu(Hero hero) {
        int userEnteredQuestMenuValue = 0;
        while (userEnteredQuestMenuValue < 1 || userEnteredQuestMenuValue > 6) {

            System.out.println("Where would you like to go?");
            System.out.println("1.  Quest 1" + "\n" + "2.  Quest 2" + "\n" + "3.  Quest 3" + "\n" + "4.  Quest 4" + "\n" + "5.  Quest 5" + "\n" + "6.  Back to main menu" + "\n");
            System.out.println("Enter the number of your choice.");
            userEnteredQuestMenuValue = userEnterMenuChoiceAndCheckForException();
            printsDirectionToPlayerToPickAValidQuestMenuChoice(userEnteredQuestMenuValue);
            if (userEnteredQuestMenuValue != 6) {
                QuestEngine quest = new QuestEngine();
                quest.newQuest(userEnteredQuestMenuValue, hero);
            }
        }
    }

    public void runCastleMenu(Hero hero) throws InterruptedException {
        int userEnteredCastleMenuValue = 0;
        while (userEnteredCastleMenuValue < 1 || userEnteredCastleMenuValue > 6) {

            System.out.println("Where would you like to go?");
            System.out.println("1.  Throne Room" + "\n" + "2.  Stables" + "\n" + "3.  Market" + "\n" + "4.  Gamble with Locals" + "\n" + "5.  Visit Oracle" + "\n" + "6.  Back to main menu" + "\n");
            System.out.println("Enter the number of your choice.");
            userEnteredCastleMenuValue = userEnterMenuChoiceAndCheckForException();
            printsDirectionToPlayerToPickAValidCastleMenuChoice(userEnteredCastleMenuValue);
            if (userEnteredCastleMenuValue != 6) {
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
        int userEnteredBattleMenuChoice = userEnterMenuChoiceAndCheckForException();
        userEnteredBattleMenuChoice = hero.doesHeroHaveMp(hero, userEnteredBattleMenuChoice);
        printsDirectionToPlayerToPickAValidBattleMenuChoice(userEnteredBattleMenuChoice);
        return userEnteredBattleMenuChoice;
    }

    public int userEnterMenuChoiceAndCheckForException(){
        int userEnteredValue = 0;
        try {
            Scanner reader1 = new Scanner(System.in);
            userEnteredValue = reader1.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("This is not an integer.");
        }
        return userEnteredValue;
    }

    //drop item menu

    public void printsDirectionToPlayerToPickAValidMainMenuChoice(int userEnteredMainMenuChoice) {

        if (userEnteredMainMenuChoice < 1 || userEnteredMainMenuChoice > 6) {
            System.out.println("Not a valid choice.  Try again." + "\n");
        }
    }

    public void printsDirectionToPlayerToPickAValidBattleMenuChoice(int userEnteredBattleMenuChoice) {

        if (userEnteredBattleMenuChoice < 1 || userEnteredBattleMenuChoice > 3) {
            System.out.println("Not a valid choice.  Try again." + "\n");
        }
    }

    public void printsDirectionToPlayerToPickAValidQuestMenuChoice(int userEnteredQuestMenuChoice) {

        if (userEnteredQuestMenuChoice < 1 || userEnteredQuestMenuChoice > 6) {
            System.out.println("Not a valid choice.  Try again." + "\n");
        }
    }

    public void printsDirectionToPlayerToPickAValidCastleMenuChoice(int userEnteredCastleMenuChoice) {

        if (userEnteredCastleMenuChoice < 1 || userEnteredCastleMenuChoice > 6) {
            System.out.println("Not a valid choice.  Try again." + "\n");
        }
    }

}