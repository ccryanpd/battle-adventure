package com.adventure;

import java.util.ArrayList;
import java.util.Scanner;

public class Hero {

    private Narrator narrator;
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
    private int initialHeroInventorySize = 1;
    private int initialEquippedItemMax = 3;
    private ArrayList<InventoryItems> inventoryItems;
    private ArrayList<InventoryItems> equippedItems;

    public Hero(Narrator narrator) throws InterruptedException {

        Scanner reader1 = new Scanner(System.in);
        narrator.whatIsHeroName();
        this.narrator = narrator;
        this.gameProgress = 1;
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
        this.inventoryItems = new ArrayList<>(initialHeroInventorySize);
        this.equippedItems = new ArrayList<>(initialEquippedItemMax);
    }

//    public int getHeroHpValue(){
//        int inventtoryHp = 0;
//        for (InventoryItem inventoryItem : inventoryItems) {
//            inventtoryHp += inventoryItem.getHitpointModifier();
//        }
//        return inventtoryHp + heroHp;
//    }

    public void addItemToHeroInventory(Hero hero, InventoryItems inventoryItem ) throws InterruptedException{

        if (inventoryItem.getItemName().equals("potion")) {
            this.potionSupply = potionSupply++;
        } else {
            if (inventoryItem.getItemName().equals("ether")) {
                this.etherSupply = etherSupply++;
            } else {
                if (inventoryItems.size() < initialHeroInventorySize){
                inventoryItems.add(inventoryItem);
                narrator.addedtoInventory(inventoryItem.getItemName());
                } else {
                    GameMenus gameMenus = new GameMenus(narrator, 2);
                    int userDropItemChoice = gameMenus.runDropItemMenu(inventoryItem.getItemName(), hero);
                    if (userDropItemChoice == 1) {
                        InventoryItems itemToRemove = gameMenus.userEnterItemAndCheckForExceptionAndInventory(hero);
                        System.out.println(itemToRemove.getItemName());


                    }
                }
            }
        }
    }

    public void removeItemFromHeroInventory(Hero hero, String inventoryItem) {



    }

    public boolean isHeroAlive(Hero hero) throws InterruptedException {
        boolean isHeroAlive = true;
        if (hero.getHeroHp() < 1) {
            isHeroAlive = false;
            narrator.youDied();
        }
        return isHeroAlive;
    }

    public int doesHeroHaveMp(Hero hero, int userEnteredBattleMenuChoice) throws InterruptedException{

        if  (hero.getHeroMp() < 1 && userEnteredBattleMenuChoice == 2){
            narrator.noMp();
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

    public ArrayList<InventoryItems> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(ArrayList<InventoryItems> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }
}

