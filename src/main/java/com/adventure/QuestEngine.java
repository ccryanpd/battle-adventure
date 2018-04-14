package com.adventure;

public class QuestEngine {



    public boolean newQuest(int questNumber, Hero hero) {
        boolean questStatus = true;
        int counter = 1;
        if (questNumber == 1) {
            int numberOfBattles = 3;
            while ((hero.getHeroHp() > 0) && (counter <= numberOfBattles)) {
                Monster monster = new Monster();
                monster.monsterGenerator(questNumber);

                System.out.println("*************************************************");
                System.out.println(hero.getHeroName() + " Vs. " + monster.getMonsterName() + "\n");
                hero.getHeroStatus();
                monster.monsterStatus();

                while ((hero.getHeroHp() > 0) && (monster.getMonsterHp() > 0)) {
                    Battle battle = new Battle();
                    questStatus = battle.newBattle(hero, monster);






                }
                counter = counter + 1;
                if (counter > numberOfBattles) {
                    System.out.println("You have completed the Quest.");
                }
            }

        }
        return questStatus;
    }
}

