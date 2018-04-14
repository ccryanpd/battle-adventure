package com.adventure;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private int choiceValueMain;
    private int choiceValueQuest;
    private boolean gameStatus = true;

    public void gameEngine() {

        Hero hero = new Hero(1, 0, 0, 10, 6, 6, 9, 5, 0, 0);
        Scanner reader1 = new Scanner(System.in);

        System.out.println("What is your name?");
        String heroName = reader1.next();
        hero.setHeroName(heroName);
        System.out.println("\n" + hero.getHeroName() + ", your adventure has begun.  Good luck." + "\n");

        while (gameStatus) {

            while (choiceValueMain < 1 || choiceValueMain > 6) {

                System.out.println(hero.getHeroName() + ", what would you like to do?");
                System.out.println("1.  Go on a Quest");
                System.out.println("2.  Go to Town");
                System.out.println("3.  Status");
                System.out.println("4.  Challenge Final Boss");
                System.out.println("5.  Save Game");
                System.out.println("6.  End Game" + "\n");
                System.out.println("Enter the number of your choice.");
                try {
                    Scanner reader2 = new Scanner(System.in);
                    choiceValueMain = reader2.nextInt();
                } catch (InputMismatchException exception) {
                    System.out.println("This is not an integer.");
                }
                System.out.println();
                if (choiceValueMain < 1 || choiceValueMain > 6) {
                    System.out.println("Not a valid choice.  Try again." + "\n");
                }
            }

            switch (choiceValueMain) {

                case 1:
                    while (choiceValueQuest < 1 || choiceValueQuest > 6) {

                        System.out.println("Where would you like to go? (In order of difficulty)");
                        System.out.println("1.  Quest 1" + "\n" + "2.  Quest 2" + "\n" + "3.  Quest 3" + "\n" + "4.  Quest 4" + "\n" + "5.  Quest 5" + "\n" + "6.  Back to main menu" + "\n");
                        System.out.println("Enter the number of your choice.");
                        try {
                            Scanner reader3 = new Scanner(System.in);
                            choiceValueQuest = reader3.nextInt();
                        } catch (InputMismatchException exception) {
                            System.out.println("This is not an integer.");
                        }
                        System.out.println();
                        if (choiceValueQuest < 1 || choiceValueQuest > 6) {
                            System.out.println("Not a valid choice.  Try again." + "\n");
                        }
                    }
                    if (choiceValueQuest != 6) {
                        QuestEngine quest = new QuestEngine();
                        this.gameStatus = quest.newQuest(choiceValueQuest, hero);
                        choiceValueQuest = 0;

                    }
                    choiceValueMain = 0;
                    choiceValueQuest = 0;
                    break;

                case 2:
                    break;
                case 3:
                    hero.getHeroStatus();
                    choiceValueMain = 0;
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    gameStatus = false;
                    break;

            }
        }
    }
}

