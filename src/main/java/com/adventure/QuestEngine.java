package com.adventure;

public class QuestEngine {
    public GameText gameText;

    public QuestEngine (GameText gameText) {
        this.gameText = gameText;
    }

    public void newQuest(int questNumber, Hero hero) throws InterruptedException{
        int counter = 1;
        if (questNumber == 1) {
            int numberOfBattles = 3;
            while ((hero.getHeroHp() > 0) && (counter <= numberOfBattles)) {
                Monster monster = new Monster(gameText);
                monster.monsterGenerator(questNumber);
                System.out.println("------------------------------BATTLE------------------------------" + "\n");
                System.out.println(hero.getHeroName() + " Vs. " + monster.getMonsterName() + "\n");
                while ((hero.getHeroHp() > 0) && (monster.getMonsterHp() > 0)) {

                    BattleFramework battle = new BattleFramework(hero, monster, gameText);
                    battle.run();
                }
                counter = counter + 1;
                if (counter > numberOfBattles && hero.isHeroAlive(hero)) {
                    System.out.println("You have completed the Quest.");
                }
            }
        }
    }
}

