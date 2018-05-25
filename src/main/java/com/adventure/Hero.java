package com.adventure;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
    private int initialHeroInventorySize = 10;
    private ArrayList<String> heroItemsInventory;
    private ArrayList<InventoryItem> inventoryItems = new ArrayList<>();
    private GameText gameText;

    public Hero(GameText gameText) {

        Scanner reader1 = new Scanner(System.in);
        System.out.println("What is your name?");
        this.gameProgress = 1;
        this.gameText = gameText;
        this.heroName = reader1.next();
        this.heroLevel = 1;
        this.heroExperiencePoints = 0;
        this.heroGold = 0;
        this.heroHp = 10;
        this.heroMp = 5;
        this.heroRegularAttack = 5;
        this.heroMagicAttack = 5;
        this.heroDefense = 5;
        this.potionSupply = 0;
        this.etherSupply = 0;
        this.heroItemsInventory = new ArrayList<>(initialHeroInventorySize);
    }

    public int getHeroHpValue(){
        int inventtoryHp = 0;
        for (InventoryItem inventoryItem : inventoryItems) {
            inventtoryHp += inventoryItem.getHitpointModifier();
        }
        return inventtoryHp + heroHp;
    }

    public void addItemToHeroInventory(Hero hero, String inventoryItem ) throws InterruptedException{

        if (inventoryItem == "potion") {
            this.potionSupply = potionSupply++;
        } else {
            if (inventoryItem == "ether") {
                this.etherSupply = etherSupply++;
            } else {
                if (heroItemsInventory.size() <= initialHeroInventorySize){
                heroItemsInventory.add(inventoryItem);
                System.out.println(inventoryItem + " -- added to inventory." + "\n");
                TimeUnit.MILLISECONDS.sleep(500);
            } else {
                    GameMenus gameMenus = new GameMenus(2, gameText);
                    int userDropItemChoice = gameMenus.runDropItemMenu(hero, inventoryItem);
                    if (userDropItemChoice == 1) {

                    }
                }
            }
        }
    }

    public void removeItemFromHeroInventory(Hero hero, String inventoryItem) {



    }

    public void printHeroStatus() throws InterruptedException {
        System.out.println("------------------------------HERO STATUS------------------------------" + "\n");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Level:  " + this.heroLevel);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Experience:  " + this.heroExperiencePoints + "/100");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Gold:  " + this.heroGold);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Hp:  " + this.heroHp);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Mp:  " + this.heroMp);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Regular Attack:  " + this.heroRegularAttack);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Magic Attack:  " + this.heroMagicAttack);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Defense:  " + this.heroDefense + "\n");
        TimeUnit.MILLISECONDS.sleep(500);
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

    public int getInitialHeroInventorySize() {
        return initialHeroInventorySize;
    }

    public void setInitialHeroInventorySize(int initialHeroInventorySize) {
        this.initialHeroInventorySize = initialHeroInventorySize;
    }

    public ArrayList<String> getHeroItemsInventory() {
        return heroItemsInventory;
    }

    public void setHeroItemsInventory(ArrayList<String> heroItemsInventory) {
        this.heroItemsInventory = heroItemsInventory;
    }
}

