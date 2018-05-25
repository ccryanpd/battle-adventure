package com.adventure;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Monster {

    private String monsterName;
    private int monsterHp;
    private int monsterRegularAttack;
    private int monsterDefense;
    private int monsterMp;
    private int monsterMagicAttack;
    private GameText gameText;

    public Monster (GameText gameText) {
        this.gameText = gameText;
    }


    public void monsterGenerator(int questNumber) {
        if (questNumber == 1) {
            Random random = new Random();
            this.monsterRegularAttack = random.nextInt(2) + 7;
            this.monsterMagicAttack = random.nextInt(3) + 10;
            this.monsterHp = random.nextInt(4) + 8;
            this.monsterMp = random.nextInt(2) + 1;
            this.monsterDefense = random.nextInt(3) + 2;
            List<String> possibleMonsterNames = Arrays.asList("MonsterA", "MonsterB", "MonsterC");
            int index = random.nextInt(possibleMonsterNames.size());
            this.monsterName = possibleMonsterNames.get(index);
        }
    }

    public void printMonsterStatus() {
        System.out.println("------------------------------MONSTER STATUS------------------------------" + "\n");
        System.out.println(this.monsterName + " -- Status");
        System.out.println("Hp:  " + this.monsterHp);
        System.out.println("Mp:  " + this.monsterMp + "\n");
        //    System.out.println("Regular Attack:  " + this.monsterRegularAttack);
        //    System.out.println("Magic Attack:  " + this.monsterRegularAttack);
        //    System.out.println("Defense:  " + this.monsterDefense + "\n");
    }

    public boolean CheckIsMonsterAlive(Monster monster) {
        boolean isMonsterAlive;
        if (monster.getMonsterHp() < 1) {
            isMonsterAlive = false;
            System.out.println(monster.getMonsterName() + " is Dead!" + "\n");
        } else {
            isMonsterAlive = true;
        }
        return isMonsterAlive;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMonsterHp() {
        return monsterHp;
    }

    public void setMonsterHp(int monsterHp) {
        this.monsterHp = monsterHp;
    }

    public int getMonsterRegularAttack() {
        return monsterRegularAttack;
    }

    public void setMonsterRegularAttack(int monsterRegularAttack) {
        this.monsterRegularAttack = monsterRegularAttack;
    }

    public int getMonsterDefense() {
        return monsterDefense;
    }

    public void setMonsterDefense(int monsterDefense) {
        this.monsterDefense = monsterDefense;
    }

    public int getMonsterMp() {
        return monsterMp;
    }

    public void setMonsterMp(int monsterMp) {
        this.monsterMp = monsterMp;
    }

    public int getMonsterMagicAttack() {
        return monsterMagicAttack;
    }

    public void setMonsterMagicAttack(int monsterMagicAttack) {
        this.monsterMagicAttack = monsterMagicAttack;
    }
}
