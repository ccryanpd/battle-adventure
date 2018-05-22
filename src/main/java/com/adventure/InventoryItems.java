package com.adventure;


import java.util.concurrent.TimeUnit;

public class InventoryItems {

    public void printHeroInventory(Hero hero) throws InterruptedException {
        System.out.println("------------------------------INVENTORY------------------------------");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("You have " + hero.getPotionSupply() + " potions.");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("You have " + hero.getEtherSupply() + " ether." + "\n");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("----------------WEAPONS - ARMOR - MAGIC - OTHER ITEMS----------------");
        System.out.println(hero.getHeroItemsInventory()+ "\n");
        TimeUnit.MILLISECONDS.sleep(500);
    }





}
