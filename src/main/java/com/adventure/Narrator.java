package com.adventure;

import org.springframework.stereotype.Service;

@Service
public class Narrator {

    private GameText gameText;
    public Sleep sleep = new Sleep();

    public Narrator(GameText gameText) {
        this.gameText = gameText;

    }
    public void beginningNarrative(Hero hero) throws InterruptedException {
        for (String line: gameText.beginningNarrative) {
            System.out.println(line);
            sleep.mediumSleep();
        }
        System.out.println();
        InventoryItems goldenKey = new InventoryItems("GOLD KEY", 0,0,0,0,0, "Story Item", false);
        hero.addItemToHeroInventory(hero, goldenKey);
    }

    public void throneRoomNarrative(Hero hero) throws InterruptedException {
        for (String line : gameText.throneRoomNarrative) {
            System.out.println(line);
            sleep.mediumSleep();
        }
        System.out.println();
        InventoryItems bronzeKey = new InventoryItems("BRONZE KEY", 0,0,0,0,0, "Story Item", false);
        hero.addItemToHeroInventory(hero, bronzeKey);
    }

    public void monsterPreemptive() throws InterruptedException {
        System.out.println(gameText.monsterPreemptiveAttack);
        sleep.mediumSleep();
        System.out.println();
    }

    public void monsterIsAttacking(Monster monster) throws InterruptedException {
        System.out.println(String.format(gameText.isAttacking, monster.getMonsterName()));
        sleep.attackActionSleep();
        System.out.println();
    }

    public void heroIsAttacking(Hero hero) throws InterruptedException {
        System.out.println(String.format(gameText.isAttacking, hero.getHeroName()));
        sleep.attackActionSleep();
        System.out.println();
    }

    public void thankYou() throws InterruptedException {
        sleep.mediumSleep();
        System.out.println(gameText.thankYou);
    }

    public void monsterAttack(Monster monster, String attackType, int result) throws InterruptedException {
        System.out.printf(gameText.monsterAttack, monster.getMonsterName(), attackType, result);
        sleep.mediumSleep();
        System.out.println();
    }

    public void monsterAttackMissed(Monster monster, String attackType) throws InterruptedException {
        System.out.printf(gameText.monsterAttackMissed, monster.getMonsterName(), attackType);
        sleep.mediumSleep();
        System.out.println();
    }

    public void heroAttack(Hero hero, Monster monster, String typeOfAttack, int result) throws InterruptedException {
        System.out.printf(gameText.heroAttack, hero.getHeroName(), typeOfAttack, monster.getMonsterName(), result);
        sleep.mediumSleep();
        System.out.println();
    }

    public void heroAttackMissed(String typeOfAttack) throws InterruptedException {
        System.out.printf(gameText.heroAttackMissed, typeOfAttack);
        sleep.mediumSleep();
        System.out.println();
    }

    public void mainMenu(Hero hero) throws InterruptedException {
        heroChoice(hero);
        for (String line : gameText.mainGameMenu) {
            System.out.print(line);
            sleep.shortSleep();
            System.out.println();
        }
        System.out.println();
    }

    public void questMenu(Hero hero) throws InterruptedException {
        heroChoice(hero);
        for (String line : gameText.questMenu) {
            System.out.print(line);
            sleep.shortSleep();
            System.out.println();
        }
        System.out.println();
    }

    public void castleMenu(Hero hero) throws InterruptedException {
        heroChoice(hero);
        for (String line : gameText.castleMenu) {
            System.out.print(line);
            sleep.shortSleep();
            System.out.println();
        }
        System.out.println();
    }

    public void battleMenu(Hero hero) throws InterruptedException {
        heroChoice(hero);
        for (String line : gameText.battleMenu) {
            System.out.print(line);
            sleep.shortSleep();
            System.out.println();
        }
        System.out.println();
    }

    private void heroChoice(Hero hero) throws InterruptedException {
        System.out.println();
        System.out.printf(gameText.heroChoice, hero.getHeroName());
        sleep.shortSleep();
        System.out.println();
    }

    public void addedtoInventory(String inventoryItem) throws InterruptedException {
        System.out.println();
        System.out.printf(gameText.addedtoInventory, inventoryItem);
        sleep.shortSleep();
        System.out.println();
    }

    public void youDied() throws InterruptedException {
        System.out.println();
        System.out.println(gameText.youDied);
        sleep.shortSleep();
        System.out.println();
    }

    public void noMp() throws InterruptedException {
        System.out.println();
        System.out.println(gameText.noMp);
        sleep.shortSleep();
        System.out.println();
    }

    public void enterDropItemChoice() throws InterruptedException {
        System.out.println();
        System.out.println(gameText.dropItemChoice);
        sleep.shortSleep();
        System.out.println();
    }

    public void notInInventory() throws InterruptedException {
        System.out.println();
        System.out.println(gameText.notInInventory);
        sleep.shortSleep();
        System.out.println();
    }

    public void printHeroInventory(Hero hero) throws InterruptedException {
        System.out.println(gameText.inventory);
        sleep.shortSleep();
        System.out.println();
        sleep.shortSleep();
        System.out.printf(gameText.heroPotion,hero.getPotionSupply());
        sleep.shortSleep();
        System.out.println();
        System.out.printf(gameText.heroEther,hero.getEtherSupply());
        sleep.shortSleep();
        System.out.println();
        System.out.println(gameText.inventoryItems);
        sleep.shortSleep();
        System.out.println();
        for (InventoryItems inventoryItem : hero.getInventoryItems()){
            System.out.println(inventoryItem.getItemName() + " ----> " + inventoryItem.getItemDescription());
            sleep.shortSleep();
            System.out.println();
        }
        System.out.print(gameText.seperator);
    }

    public void printMonsterStatus(Monster monster) throws InterruptedException {
        System.out.println(gameText.monsterStatus);
        sleep.shortSleep();
        System.out.println();
        System.out.printf(gameText.monsterName,monster.getMonsterName());
        sleep.shortSleep();
        System.out.println();
        System.out.printf(gameText.monsterHp,monster.getMonsterHp());
        sleep.shortSleep();
        System.out.println();
        System.out.printf(gameText.monsterMp, monster.getMonsterMp());
        sleep.shortSleep();
        System.out.println();
    }

    public void questCompleted() throws InterruptedException {
        System.out.println();
        System.out.println(gameText.questCompleted);
        sleep.shortSleep();
        System.out.println();
    }

    public void monsterIsDead(Monster monster) throws InterruptedException {
        System.out.println();
        System.out.printf(gameText.monsterIsDead, monster.getMonsterName());
        sleep.shortSleep();
        System.out.println();
    }

    public void battleIntroduction(Monster monster, Hero hero) throws InterruptedException {
        System.out.println(gameText.battle);
        sleep.shortSleep();
        System.out.printf(gameText.vs, hero.getHeroName(), monster.getMonsterName());
        sleep.shortSleep();
        System.out.println();
    }

    public void printHeroStatus(Hero hero) throws InterruptedException {
        System.out.println(gameText.heroStatus);
        sleep.shortSleep();
        System.out.println();
        System.out.printf(gameText.heroLevel,hero.getHeroLevel());
        sleep.shortSleep();
        System.out.println();
        System.out.printf(gameText.heroExperience,hero.getHeroExperiencePoints());
        sleep.shortSleep();
        System.out.println();
        System.out.printf(gameText.heroGold,hero.getHeroGold());
        sleep.shortSleep();
        System.out.println();
        System.out.printf(gameText.heroHp,hero.getHeroHp());
        sleep.shortSleep();
        System.out.println();
        System.out.printf(gameText.heroMp,hero.getHeroMp());
        sleep.shortSleep();
        System.out.println();
        System.out.printf(gameText.heroRegularAttack,hero.getHeroRegularAttack());
        sleep.shortSleep();
        System.out.println();
        System.out.printf(gameText.heroMagicAttack,hero.getHeroMagicAttack());
        sleep.shortSleep();
        System.out.println();
        System.out.printf(gameText.heroDefense,hero.getHeroDefense());
        sleep.shortSleep();
        System.out.println();
    }

    public void dropItemMenu(String inventoryItem, Hero hero) throws InterruptedException {
        System.out.println();
        System.out.printf(gameText.dropItemMenu, inventoryItem);
        sleep.shortSleep();
        System.out.println();
        printHeroInventory(hero);
        sleep.shortSleep();
        System.out.println();
        yesOrNo();
        sleep.shortSleep();
        System.out.println();
    }

    public void whatIsHeroName() throws InterruptedException {
        System.out.println();
        System.out.println(gameText.heroName);
        sleep.shortSleep();
        System.out.println();
    }

    public void yesOrNo() throws InterruptedException {
        for (String line : gameText.yesOrNo) {
            System.out.print(line);
            sleep.shortSleep();
            System.out.println();
        }
        System.out.println();
    }

    public void notAnInteger() throws InterruptedException {
        System.out.println();
        System.out.println(gameText.notAnInteger);
        sleep.shortSleep();
        System.out.println();
    }

    public void tryAgain() throws InterruptedException {
        System.out.println();
        System.out.println(gameText.tryAgain);
        sleep.shortSleep();
        System.out.println();
    }







}