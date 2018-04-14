package com.adventure;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Battle {

    private int choiceValueBattle;
    private boolean battleStatus = true;


    public boolean newBattle(Hero hero, Monster monster) {
        Random random = new Random();
        BattleActions battleActions = new BattleActions();

        int randomNumber = random.nextInt(5) + 1;
        if (randomNumber == 1) {         //20% chance of monster preemptive attack
            hero.getHeroStatus();
            monster.monsterStatus();
            this.battleStatus = battleActions.monsterAttack(hero, monster);
        }

        if (battleStatus) {

            while (battleStatus) {

                while ((choiceValueBattle < 1 || choiceValueBattle > 3) && (battleStatus = true)) {

                    System.out.println(hero.getHeroName() + ", choose your action?");
                    System.out.println("1.  Regular Attack");
                    System.out.println("2.  Magic Attack");
                    System.out.println("3.  Roll Dice");
                    System.out.println("Enter the number of your choice.");
                    try {
                        Scanner reader1 = new Scanner(System.in);
                        choiceValueBattle = reader1.nextInt();
                    } catch (InputMismatchException exception) {
                        System.out.println("This is not an integer." + "\n");
                    }
                    if  (hero.getHeroMp() < 1 && choiceValueBattle == 2){
                        System.out.println("You do not have any Mp.  You cannot use a magic attack.");
                        choiceValueBattle = 0;
                    }
                    if (choiceValueBattle < 1 || choiceValueBattle > 3) {
                        System.out.println("Not a valid choice.  Try again." + "\n");
                    }
                }
                switch (choiceValueBattle) {

                    case 1:
                        this.battleStatus = battleActions.heroRegularAttack(hero, monster);
                        break;

                    case 2:
                        this.battleStatus = battleActions.heroMagicAttack(hero, monster);
                        break;

                    case 3:
                        break;
                }

                if (this.battleStatus) {
                    monster.monsterStatus();
                    hero.getHeroStatus();
                    this.battleStatus = battleActions.monsterAttack(hero, monster);
                }
                choiceValueBattle = 0;
            }

        }
        return this.battleStatus;
    }
}

