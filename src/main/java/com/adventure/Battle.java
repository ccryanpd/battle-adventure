package com.adventure;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Battle {

    private Hero hero;
    private Monster monster;
    private int userEnteredBattleMenuChoice;
    private boolean isHeroAndMonsterAlive = true;
    private BattleActions battleActions;

    public Battle(Hero hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
        battleActions = new BattleActions();
    }


    public void run() {
        if (isPreemptiveAttack()) {
            hero.printHeroStatus();
            monster.printMonsterStatus();
            this.isHeroAndMonsterAlive = battleActions.monsterAttack(hero, monster);
        }

        if (isHeroAndMonsterAlive) {

            while (isHeroAndMonsterAlive) {

                while ((userEnteredBattleMenuChoice < 1 || userEnteredBattleMenuChoice > 3) && (isHeroAndMonsterAlive = true)) {

                    GameMenus gameMenus = new GameMenus();
                    userEnteredBattleMenuChoice = gameMenus.runBattleMenu(hero);
                }
                    switch (userEnteredBattleMenuChoice) {

                        case 1:
                            this.isHeroAndMonsterAlive = battleActions.heroRegularAttack(hero, monster);
                            break;

                        case 2:
                            this.isHeroAndMonsterAlive = battleActions.heroMagicAttack(hero, monster);
                            break;

                        case 3:
                            break;
                    }
                    if (this.isHeroAndMonsterAlive) {
                        monster.printMonsterStatus();
                        hero.printHeroStatus();
                        this.isHeroAndMonsterAlive = battleActions.monsterAttack(hero, monster);
                    }
                    userEnteredBattleMenuChoice = 0;
                }
            }
        }

    private boolean isPreemptiveAttack () {
        return getRandomNumberBetweenOneAnd(5) == 1;    //20% chance of monster preemptive attack
    }

    private int getRandomNumberBetweenOneAnd ( int bound){
        return new Random().nextInt(bound) + 1;
    }
}

