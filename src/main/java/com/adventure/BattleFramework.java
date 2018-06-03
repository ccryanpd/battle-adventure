package com.adventure;

import java.util.Random;

public class BattleFramework {

    private Hero hero;
    private Monster monster;
    private boolean isHeroAndMonsterAlive;
    private BattleActions battleActions;

    private Narrator narrator;

    public BattleFramework(Narrator narrator, Hero hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
        this.isHeroAndMonsterAlive = true;
        this.narrator = narrator;
        this.battleActions = new BattleActions(narrator);
    }

    public void run() throws InterruptedException {

        int userEnteredBattleMenuChoice = 0;
        if (isPreemptiveAttack()) {
            narrator.monsterPreemptive();
            this.isHeroAndMonsterAlive = battleActions.monsterAttack(hero, monster);
        }

        if (isHeroAndMonsterAlive) {

            while (isHeroAndMonsterAlive) {

                while ((userEnteredBattleMenuChoice < 1 || userEnteredBattleMenuChoice > 3) && (isHeroAndMonsterAlive = true)) {
                    narrator.printHeroStatus(hero);
                    narrator.printMonsterStatus(monster);
                    GameMenus gameMenus = new GameMenus(narrator, 3);
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

