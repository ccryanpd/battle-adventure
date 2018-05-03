package com.adventure;

import java.util.concurrent.TimeUnit;


public class Story {

    public void beginningNarrative(Hero hero) throws InterruptedException {
        System.out.println("------------------------------THE LOST KEYS------------------------------");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\n" + "ZZZZZ.....ZZZZZ.....ZZZZZ.....ZZZZ....Zzz...Zz..z........" + "\n");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("The sun shines bright overhead as you awake confused in the middle of a field.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("The field shows no signs of crops.  The ground is extremely dry.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("You have no memory of where or who you are.  There is an empty backpack beside you.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("You look around at your surroundings.  There is a castle to the north.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("As you gaze toward the castle, a magical fairy appears in front of you.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("The fairy said --> " + hero.getHeroName() + ", go and speak with the King so your destiny may become clear." + "\n");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("Before the fairy disappears she hands you a golden key.  You put it in your pack.");
        hero.addItemToHeroInventory(hero, "Bag of Vegetables");
    }

    public void throneRoomNarrative1(Hero hero) throws InterruptedException{
        System.out.println("------------------------------THE THRONE ROOM------------------------------");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("Son!!  Is that you?!  I cannot believe my eyes.  ");


    }
}
