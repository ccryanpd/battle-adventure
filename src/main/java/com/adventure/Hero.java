package com.adventure;

import java.util.ArrayList;
import java.util.Scanner;

public class Hero {

    private String heroName;
    private int heroLevel;
    private int heroExperiencePoints;
    private int heroGold;
    private int heroHp;
    private int heroMp;
    private int heroRegularAttack;
    private int heroMagicAttack;
    private int heroDefense;
    private int potionSupply;
    private int etherSupply;
    private int gameProgress;
    private int intialHeroInventorySize = 10;
    private ArrayList<String> heroItemsInventory = new ArrayList<String>(intialHeroInventorySize);



    public Hero(int gameProgress, int heroLevel, int heroExperiencePoints, int heroGold, int heroHp, int heroMp,
                int heroRegularAttack, int heroMagicAttack, int heroDefense, int potion, int ether) {

        Scanner reader1 = new Scanner(System.in);
        System.out.println("What is your name?");
        this.gameProgress = gameProgress;
        this.heroName = reader1.next();
        this.heroLevel = heroLevel;
        this.heroExperiencePoints = heroExperiencePoints;
        this.heroGold = heroGold;
        this.heroHp = heroHp;
        this.heroMp = heroMp;
        this.heroRegularAttack = heroRegularAttack;
        this.heroMagicAttack = heroMagicAttack;
        this.heroDefense = heroDefense;
        this.potionSupply = potion;
        this.etherSupply = ether;



    }

    public void addItemToHeroInventory(Hero hero, String inventoryItem ){

        if (inventoryItem == "potion") {
            this.potionSupply = potionSupply++;
        } else {
            if (inventoryItem == "ether") {
                this.etherSupply = etherSupply++;
            } else {
                if (heroItemsInventory.size() <= intialHeroInventorySize){
                heroItemsInventory.add(inventoryItem);
            } else {
                    //menu for item removal
                }
            }
        }
    }

    public void printHeroStatus() {
        System.out.println(this.heroName + " -- Status");
        System.out.println("Level:  " + this.heroLevel);
        System.out.println("Experience:  " + this.heroExperiencePoints + "/100");
        System.out.println("Gold:  " + this.heroGold);
        System.out.println("Hp:  " + this.heroHp);
        System.out.println("Mp:  " + this.heroMp);
        System.out.println("Regular Attack:  " + this.heroRegularAttack);
        System.out.println("Magic Attack:  " + this.heroMagicAttack);
        System.out.println("Defense:  " + this.heroDefense);
        System.out.println("Potion:  " + this.potionSupply);
        System.out.println("Ether:  " + this.etherSupply + "\n");
    }

    public boolean isHeroAlive(Hero hero) {
        boolean isHeroAlive = true;
        if (hero.getHeroHp() < 1) {
            isHeroAlive = false;
            System.out.println("You died.");
        }
        return isHeroAlive;
    }

    public int doesHeroHaveMp(Hero hero, int userEnteredBattleMenuChoice){

        if  (hero.getHeroMp() < 1 && userEnteredBattleMenuChoice == 2){
            System.out.println("You do not have any Mp.  You cannot use a magic attack.");
            userEnteredBattleMenuChoice = 0;
        }
        return userEnteredBattleMenuChoice;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getHeroLevel() {
        return heroLevel;
    }

    public void setHeroLevel(int heroLevel) {
        this.heroLevel = heroLevel;
    }

    public int getHeroExperiencePoints() {
        return heroExperiencePoints;
    }

    public void setHeroExperiencePoints(int heroExperiencePoints) {
        this.heroExperiencePoints = heroExperiencePoints;
    }

    public int getHeroGold() {
        return heroGold;
    }

    public void setHeroGold(int heroGold) {
        this.heroGold = heroGold;
    }

    public int getHeroHp() {
        return heroHp;
    }

    public void setHeroHp(int heroHp) {
        this.heroHp = heroHp;
    }

    public int getHeroMp() {
        return heroMp;
    }

    public void setHeroMp(int heroMp) {
        this.heroMp = heroMp;
    }

    public int getHeroRegularAttack() {
        return heroRegularAttack;
    }

    public void setHeroRegularAttack(int heroRegularAttack) {
        this.heroRegularAttack = heroRegularAttack;
    }

    public int getHeroMagicAttack() {
        return heroMagicAttack;
    }

    public void setHeroMagicAttack(int heroMagicAttack) {
        this.heroMagicAttack = heroMagicAttack;
    }

    public int getHeroDefense() {
        return heroDefense;
    }

    public void setHeroDefense(int heroDefense) {
        this.heroDefense = heroDefense;
    }

    public int getPotionSupply() {
        return potionSupply;
    }

    public void setPotionSupply(int potionSupply) {
        this.potionSupply = potionSupply;
    }

    public int getEtherSupply() {
        return etherSupply;
    }

    public void setEtherSupply(int etherSupply) {
        this.etherSupply = etherSupply;
    }

    public int getGameProgress() {
        return gameProgress;
    }

    public void setGameProgress(int gameProgress) {
        this.gameProgress = gameProgress;
    }
}

