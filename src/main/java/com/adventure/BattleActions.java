package com.adventure;

import java.util.Random;

public class BattleActions {

    public boolean monsterAttack(Hero hero, Monster monster) {
//        boolean isHeroAlive;
        Random random = new Random();
        int typeOfAttack = random.nextInt(3) + 1;
        if (typeOfAttack == 1 && monster.getMonsterMp() > 0) {         //monster magic attack
            double monsterAttackModifier = (random.nextInt(4) + 7) * .1;
            double monsterAttack = monsterAttackModifier * monster.getMonsterMagicAttack();
            double heroDefenseModifier = (random.nextInt(3) + 8) * .1;
            double heroDefense = heroDefenseModifier * hero.getHeroDefense();
            int result = (int) monsterAttack - (int) heroDefense;
            monster.setMonsterMp(monster.getMonsterMp() - 1);

            if (result > 0) {
                int finalResult = hero.getHeroHp() - result;
                hero.setHeroHp(finalResult);
                System.out.println(monster.getMonsterName() + " used a magic attack. Your Hp was reduced by " + result + "\n");
            } else {
                System.out.println(monster.getMonsterName() + " Magic Attack Missed!" + "\n");
            }
        } else {
            double monsterAttackModifier = (random.nextInt(4) + 7) * .1;
            double monsterAttack = monsterAttackModifier * monster.getMonsterRegularAttack();
            double heroDefenseModifier = (random.nextInt(3) + 8) * .1;
            double heroDefense = heroDefenseModifier * hero.getHeroDefense();
            int result = (int) monsterAttack - (int) heroDefense;
            if (result > 0) {
                int finalResult = hero.getHeroHp() - result;
                hero.setHeroHp(finalResult);
                System.out.println(monster.getMonsterName() + " punched you in the face. Your Hp was reduced by " + result + "\n");
            } else {
                System.out.println(monster.getMonsterName() + " Regular Attack Missed!" + "\n");
            }
        }
        return hero.isHeroAlive(hero);
    }

    public boolean heroRegularAttack(Hero hero, Monster monster) {
        boolean isMonsterAlive;
        Random random = new Random();
        double heroAttackModifier = (random.nextInt(4) + 7) * .1;
        double heroAttack = heroAttackModifier * hero.getHeroRegularAttack();
        double monsterDefenseModifier = (random.nextInt(3) + 8) * .1;
        double monsterDefense = monsterDefenseModifier * monster.getMonsterDefense();
        int result = (int) heroAttack - (int) monsterDefense;
        if (result > 0) {
            int finalResult = monster.getMonsterHp() - result;
            monster.setMonsterHp(finalResult);
            System.out.println(hero.getHeroName() + " kicked " + monster.getMonsterName() + " in the stones. Hp reduced by " + result + "\n");
        } else {
            System.out.println("Your Regular Attack Missed!" + "\n");
        }
        if (monster.getMonsterHp() < 1) {
            isMonsterAlive = false;
            System.out.println(monster.getMonsterName() + " is Dead!" + "\n");
        } else {
            isMonsterAlive = true;
        }
        return isMonsterAlive;
    }

    public boolean heroMagicAttack(Hero hero, Monster monster) {
        boolean isMonsterAlive;
        Random random = new Random();
        double heroAttackModifier = (random.nextInt(4) + 7) * .1;
        double heroAttack = heroAttackModifier * hero.getHeroMagicAttack();
        double monsterDefenseModifier = (random.nextInt(3) + 8) * .1;
        double monsterDefense = monsterDefenseModifier * monster.getMonsterDefense();
        int result = (int) heroAttack - (int) monsterDefense;
        hero.setHeroMp(hero.getHeroMp() - 1);
        if (result > 0) {
            int finalResult = monster.getMonsterHp() - result;
            monster.setMonsterHp(finalResult);
            System.out.println(hero.getHeroName() + " uses magic. " + monster.getMonsterName() + " Hp is reduced by " + result + "\n");
        } else {
            System.out.println("Your Magic Attack Missed!" + "\n");
        }
        if (monster.getMonsterHp() < 1) {
            isMonsterAlive = false;
            System.out.println(monster.getMonsterName() + " is Dead!" + "\n");
        } else {
            isMonsterAlive = true;
        }
        return isMonsterAlive;
    }
}
