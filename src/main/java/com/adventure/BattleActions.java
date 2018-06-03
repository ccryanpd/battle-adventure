package com.adventure;

import java.util.Random;

public class BattleActions {
    private double attackModifier;
    private double defenseModifier;
    private Narrator narrator;

    public BattleActions(Narrator narrator) {
        this.narrator = narrator;
    }


    private void determineBattleModifiers() {
        double multiplyByPointOne = .1;
        this.attackModifier = getRandomNumberBetweenSevenAnd(4) * multiplyByPointOne;
        this.defenseModifier = getRandomNumberBetweenEightAnd(3) * multiplyByPointOne;
    }

    public boolean monsterAttack(Hero hero, Monster monster) throws InterruptedException{
        determineBattleModifiers();
        int isMonsterAttackMagic = getRandomNumberBetweenOneAnd(3);
        if (isMonsterAttackMagic == 1 && monster.getMonsterMp() > 0) {      // 1 = monster magic attack -- 2 or 3 = monster regular attack
            monster.setMonsterMp(monster.getMonsterMp() - 1);
            double monsterAttack = attackModifier * monster.getMonsterMagicAttack();
            double heroDefense = defenseModifier * hero.getHeroDefense();
            monsterAttackResult(monster, hero, monsterAttack, heroDefense, isMonsterAttackMagic);

        } else {
            double monsterAttack = attackModifier * monster.getMonsterRegularAttack();
            double heroDefense = defenseModifier * hero.getHeroDefense();
            monsterAttackResult(monster, hero, monsterAttack, heroDefense, isMonsterAttackMagic);
        }
        return hero.isHeroAlive(hero);
    }

    public boolean heroRegularAttack(Hero hero, Monster monster) throws InterruptedException {
        determineBattleModifiers();
        String typeOfAttack = "Regular";
        double heroAttack = attackModifier * hero.getHeroRegularAttack();
        double monsterDefense = defenseModifier * monster.getMonsterDefense();
        heroAttackResult(hero, monster, heroAttack, monsterDefense, typeOfAttack);
        return monster.CheckIsMonsterAlive(monster);
    }

    public boolean heroMagicAttack(Hero hero, Monster monster) throws InterruptedException {
        determineBattleModifiers();
        String typeOfAttack = "Magic";
        double heroAttack = attackModifier * hero.getHeroMagicAttack();
        double monsterDefense = defenseModifier * monster.getMonsterDefense();
        hero.setHeroMp(hero.getHeroMp() - 1);
        heroAttackResult(hero, monster, heroAttack, monsterDefense, typeOfAttack);
        return monster.CheckIsMonsterAlive(monster);
    }

    private int getRandomNumberBetweenSevenAnd ( int bound){
        return new Random().nextInt(bound) + 7;
    }

    private int getRandomNumberBetweenEightAnd ( int bound){
        return new Random().nextInt(bound) + 8;
    }

    private int getRandomNumberBetweenOneAnd ( int bound){
        return new Random().nextInt(bound) + 1;
    }

    private void monsterAttackResult (Monster monster, Hero hero, double monsterAttack, double heroDefense, int typeOfAttack) throws InterruptedException {
        String attackType;
        if (typeOfAttack == 1) {
            attackType = "Magic";
        } else {
            attackType = "Regular";
        }
        int result = (int) monsterAttack - (int) heroDefense;
        narrator.monsterIsAttacking(monster);
        if (result > 0) {
            int finalResult = hero.getHeroHp() - result;
            hero.setHeroHp(finalResult);
            narrator.monsterAttack(monster, attackType, result);
        } else {
            narrator.monsterAttackMissed(monster, attackType);
        }
    }

    private void heroAttackResult (Hero hero, Monster monster, double heroAttack, double monsterDefense, String typeOfAttack) throws InterruptedException{
        int result = (int) heroAttack - (int) monsterDefense;
        narrator.heroIsAttacking(hero);
        if (result > 0) {
            int finalResult = monster.getMonsterHp() - result;
            monster.setMonsterHp(finalResult);
            narrator.heroAttack(hero, monster, typeOfAttack, result);
        } else {
            narrator.heroAttackMissed(typeOfAttack);
        }
    }
}
