package com.adventure;

public class QuestEngine {

    private Narrator narrator;

    public QuestEngine (Narrator narrator) {
        this.narrator = narrator;
    }

    public void newQuest(int questNumber, Hero hero) throws InterruptedException{
        int counter = 1;
        if (questNumber == 1) {
            int numberOfBattles = 3;
            while ((hero.getHeroHp() > 0) && (counter <= numberOfBattles)) {
                Monster monster = new Monster(narrator);
                monster.monsterGenerator(questNumber);
                narrator.battleIntroduction(monster, hero);
                while ((hero.getHeroHp() > 0) && (monster.getMonsterHp() > 0)) {

                    BattleFramework battle = new BattleFramework(narrator, hero, monster);
                    battle.run();
                }
                counter = counter + 1;
                if (counter > numberOfBattles && hero.isHeroAlive(hero)) {
                    narrator.questCompleted();
                }
            }
        }
    }
}

