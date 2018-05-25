package com.adventure;

import java.util.Random;

public class BattleFramework {

    private Hero hero;
    private Monster monster;
    private boolean isHeroAndMonsterAlive;
    private BattleActions battleActions = new BattleActions(this.gameText);
    private GameText gameText;

    public BattleFramework(Hero hero, Monster monster, GameText gameText) {
        this.hero = hero;
        this.monster = monster;
        this.isHeroAndMonsterAlive = true;
        this.gameText = gameText;

    }

    public void run() throws InterruptedException {

        int userEnteredBattleMenuChoice = 0;
        if (isPreemptiveAttack()) {
            gameText.monsterPreemptive();
            this.isHeroAndMonsterAlive = battleActions.monsterAttack(hero, monster);
        }

        if (isHeroAndMonsterAlive) {

            while (isHeroAndMonsterAlive) {

                while ((userEnteredBattleMenuChoice < 1 || userEnteredBattleMenuChoice > 3) && (isHeroAndMonsterAlive = true)) {
                    hero.printHeroStatus();
                    monster.printMonsterStatus();
                    GameMenus gameMenus = new GameMenus(3, gameText);
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

